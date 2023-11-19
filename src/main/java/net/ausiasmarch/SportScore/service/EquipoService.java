package net.ausiasmarch.SportScore.service;

import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import net.ausiasmarch.SportScore.entity.EquipoEntity;
import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.EquipoRepository;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository oEquipoRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public EquipoEntity get(Long id) {
        return oEquipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo not found"));
    }

    public List<EquipoEntity> getAll() {
        return oEquipoRepository.findAll();
    }

    public Page<EquipoEntity> getPage(Pageable oPageable) {
        return oEquipoRepository.findAll(oPageable);
    }

    @Transactional
    public Long create(EquipoEntity oEquipoEntity) {
        oSessionService.onlyAdmins();
        oEquipoEntity.setId(null);
        return oEquipoRepository.save(oEquipoEntity).getId();
    }

    @Transactional
    public EquipoEntity update(EquipoEntity oEquipoEntityToSet) {
        EquipoEntity oEquipoEntityFromDatabase = this.get(oEquipoEntityToSet.getId());
        oSessionService.onlyAdminsOrUsersWithIsOwnData(oEquipoEntityFromDatabase.getId());
        if (oSessionService.isUser()) {
            JugadorEntity oJugadorEntity = oSessionService.getSessionUser();
            if (oJugadorEntity.getEquipo() != null
                    && oJugadorEntity.getEquipo().getId().equals(oEquipoEntityToSet.getId())) {
                return oEquipoRepository.save(oEquipoEntityToSet);
            } else {
                throw new ResourceNotFoundException("Unauthorized");
            }
        } else {
            return oEquipoRepository.save(oEquipoEntityToSet);
        }
    }

    @Transactional
    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oEquipoRepository.deleteById(id);
        return id;
    }

    public EquipoEntity getOneRandom() {
        oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * oEquipoRepository.count()), 1);
        return oEquipoRepository.findAll(oPageable).getContent().get(0);
    }

    @Transactional
    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            String nombre = DataGenerationHelper.generarNombreEquipo();
            String paisOrigen = DataGenerationHelper.generarNacionalidad();
            String ciudadOrigen = DataGenerationHelper.generarCiudad();
            LocalDate fechaFundacion = DataGenerationHelper.generarFechaFundacionEquipo();
            String entrenador = DataGenerationHelper.getRandomEntrenador();
            oEquipoRepository.save(new EquipoEntity(nombre, paisOrigen, ciudadOrigen, fechaFundacion, entrenador));
        }
        return oEquipoRepository.count();
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oEquipoRepository.deleteAll();
        oEquipoRepository.resetAutoIncrement();
        oEquipoRepository.flush();
        return oEquipoRepository.count();
    }
}
