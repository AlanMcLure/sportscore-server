package net.ausiasmarch.SportScore.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import net.ausiasmarch.SportScore.entity.EquipoEntity;
import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.JugadorRepository;
import net.ausiasmarch.SportScore.repository.EquipoRepository;

@Service
public class JugadorService {

    private final String sportscorePASSWORD = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    @Autowired
    JugadorRepository oJugadorRepository;

    @Autowired
    EquipoRepository oEquipoRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public JugadorEntity get(Long id) {
        return oJugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jugador not found"));
    }

    public Page<JugadorEntity> getPage(Pageable oPageable, Long equipoId) {
        oSessionService.onlyAdmins();
        if (equipoId == 0) {
            return oJugadorRepository.findAll(oPageable);
        } else {
            return oJugadorRepository.findByEquipoId(equipoId, oPageable);
        }

    }

    @Transactional
    public Long create(JugadorEntity oJugadorEntity) {
        oSessionService.onlyAdmins();
        oJugadorEntity.setId(null);
        oJugadorEntity.setPassword(sportscorePASSWORD);
        return oJugadorRepository.save(oJugadorEntity).getId();
    }

    @Transactional
    public JugadorEntity update(JugadorEntity oJugadorEntityToSet) {
        JugadorEntity oJugadorEntityFromDatabase = this.get(oJugadorEntityToSet.getId());
        oSessionService.onlyAdminsOrUsersWithIsOwnData(oJugadorEntityFromDatabase.getId());
        if (oSessionService.isUser()) {
            oJugadorEntityToSet.setId(null);
            oJugadorEntityToSet.setRole(oJugadorEntityFromDatabase.getRole());
            oJugadorEntityToSet.setPassword(sportscorePASSWORD);
            return oJugadorRepository.save(oJugadorEntityToSet);
        } else {
            oJugadorEntityToSet.setId(null);
            oJugadorEntityToSet.setPassword(sportscorePASSWORD);
            return oJugadorRepository.save(oJugadorEntityToSet);
        }
    }

    @Transactional
    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oJugadorRepository.deleteById(id);
        return id;
    }

    public JugadorEntity getOneRandom() {
        oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * oJugadorRepository.count()), 1);
        return oJugadorRepository.findAll(oPageable).getContent().get(0);
    }

    // Falta hacer esta función bien con el DataGenerator
    @Transactional
    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            String nombre = "";
            String apellido1 = "";
            String apellido2 = "";

            String nacionalidad = "";
            String posicion = "";
            LocalDate fechaNacimiento = LocalDate.of(2002, 10, 16);
            ;
            String email = "";
            String password = "";
            String username = "";
            Boolean role = false;
            EquipoEntity equipo;
        }
        return oEquipoRepository.count();
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oJugadorRepository.deleteAll();
        oJugadorRepository.resetAutoIncrement();

        LocalDate fechaNacimiento = LocalDate.of(2002, 10, 16);
        EquipoEntity equipo = oEquipoRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo not found"));
        JugadorEntity oJugadorEntity1 = new JugadorEntity(1L, "Alan", "McLure", "Alarcón", "España", "Delantero",
                fechaNacimiento,
                "pedropicapiedra@ausiasmarch.net", "pedropicapiedra", sportscorePASSWORD, true, equipo);
        oJugadorRepository.save(oJugadorEntity1);
        return oJugadorRepository.count();
    }

}
