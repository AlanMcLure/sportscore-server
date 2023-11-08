package net.ausiasmarch.SportScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.JugadorRepository;

@Service
public class JugadorService {

    private final String sportscorePASSWORD = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    @Autowired
    JugadorRepository oJugadorRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public JugadorEntity get(Long id) {
        return oJugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jugador not found"));
    }

    public Page<JugadorEntity> getPage(Pageable oPageable) {
        oSessionService.onlyAdmins();
        return oJugadorRepository.findAll(oPageable);
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
        oSessionService.onlyAdminsOrJugadoresWithIisOwnData(oJugadorEntityFromDatabase.getId());
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

    /*
     * public Long populate(Integer amount) {
     * oSessionService.onlyAdmins();
     * for (int i = 0; i < amount; i++) {
     * String name = DataGenerationHelper.getRadomName();
     * String surname = DataGenerationHelper.getRadomSurname();
     * String lastname = DataGenerationHelper.getRadomSurname();
     * String email = name.substring(0, 3) + surname.substring(0, 3) +
     * lastname.substring(0, 2) + i
     * + "@ausiasmarch.net";
     * String username = DataGenerationHelper
     * .doNormalizeString(
     * name.substring(0, 3) + surname.substring(1, 3) + lastname.substring(1, 2) +
     * i);
     * oUserRepository.save(new UserEntity(name, surname, lastname, email, username,
     * "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", true));
     * }
     * return oUserRepository.count();
     * }
     */

    /*
     * @Transactional
     * public Long empty() {
     * oSessionService.onlyAdmins();
     * oUserRepository.deleteAll();
     * oUserRepository.resetAutoIncrement();
     * UserEntity oUserEntity1 = new UserEntity(1L, "Pedro", "Picapiedra", "Roca",
     * "pedropicapiedra@ausiasmarch.net", "pedropicapiedra", foxforumPASSWORD,
     * false);
     * oUserRepository.save(oUserEntity1);
     * oUserEntity1 = new UserEntity(2L, "Pablo", "Mármol", "Granito",
     * "pablomarmol@ausiasmarch.net",
     * "pablomarmol", foxforumPASSWORD, true);
     * oUserRepository.save(oUserEntity1);
     * return oUserRepository.count();
     * }
     */
}
