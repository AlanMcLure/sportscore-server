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
    
    @Autowired
    JugadorRepository oJugadorRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    public JugadorEntity get(Long id) {
        return oJugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public Page<JugadorEntity> getPage(Pageable oPageable) {
        return oJugadorRepository.findAll(oPageable);
    }

    public Long create(JugadorEntity oJugadorEntity) {
        String strJWTusername = oHttpServletRequest.getAttribute("username").toString();
        JugadorEntity oJugadorEntityInSession = oJugadorRepository.findByUsername(strJWTusername)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (Boolean.FALSE.equals(oJugadorEntityInSession.getRole())) {
            oJugadorEntity.setId(null);
            oJugadorEntity.setPassword("e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e");
            return oJugadorRepository.save(oJugadorEntity).getId();
        } else {
            throw new ResourceNotFoundException("Unauthorized");
        }
    }

    public JugadorEntity update(JugadorEntity oJugadorEntity) {
        String strJWTusername = oHttpServletRequest.getAttribute("username").toString();
        JugadorEntity oJugadorEntityInSession = oJugadorRepository.findByUsername(strJWTusername)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (Boolean.FALSE.equals(oJugadorEntityInSession.getRole())) {
            oJugadorEntity.setId(null);
            oJugadorEntity.setPassword("e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e");
            return oJugadorRepository.save(oJugadorEntity);
        } else {
            throw new ResourceNotFoundException("Unauthorized");
        }
    }

    public Long delete(Long id) {
        String strJWTusername = oHttpServletRequest.getAttribute("username").toString();
        JugadorEntity oJugadorEntityInSession = oJugadorRepository.findByUsername(strJWTusername)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (Boolean.FALSE.equals(oJugadorEntityInSession.getRole())) {
            oJugadorRepository.deleteById(id);
            return id;
        } else {
            throw new ResourceNotFoundException("Unauthorized");
        }
    }

    public JugadorEntity getOneRandom() {
        Pageable oPageable = PageRequest.of((int) (Math.random() * oJugadorRepository.count()), 1);
        return oJugadorRepository.findAll(oPageable).getContent().get(0);
    }

    /*
    public Long populate(Integer amount) {
        String strJWTusername = oHttpServletRequest.getAttribute("username").toString();
        JugadorEntity oJugadorEntity = oJugadorRepository.findByUsername(strJWTusername)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (Boolean.FALSE.equals(oJugadorEntity.getRole())) {
            for (int i = 0; i < amount; i++) {
                String nombre = DataGenerationHelper.getRadomName();
                String apellido1 = DataGenerationHelper.getRadomSurname();
                String apellido2 = DataGenerationHelper.getRadomSurname();
                String email = name.substring(0, 3) + surname.substring(0, 3) + lastname.substring(0, 2) + i
                        + "@ausiasmarch.net";
                String username = DataGenerationHelper
                        .doNormalizeString(
                                name.substring(0, 3) + surname.substring(1, 3) + lastname.substring(1, 2) + i);
                oJugadorRepository.save(new UserEntity(name, surname, lastname, email, username,
                        "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", true));
            }
            return oJugadorRepository.count();
        } else {
            throw new ResourceNotFoundException("Unauthorized");
        }

    }
    */

    /*
    @Transactional
    public Long empty() {
        String strJWTusername = oHttpServletRequest.getAttribute("username").toString();
        JugadorEntity oJugadorEntity = oJugadorRepository.findByUsername(strJWTusername)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (Boolean.FALSE.equals(oJugadorEntity.getRole())) {
            oJugadorRepository.deleteAll();
            oJugadorRepository.resetAutoIncrement();
            JugadorEntity oJugadorEntity1 = new JugadorEntity(1L, "Pedro", "Picapiedra", "Roca",
                    "pedropicapiedra@ausiasmarch.net",
                    "pedropicapiedra", "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", false);
            oJugadorRepository.save(oJugadorEntity1);
            oJugadorEntity1 = new JugadorEntity(2L, "Pablo", "Mármol", "Granito", "pablomarmol@ausiasmarch.net",
                    "pablomarmol",
                    "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", true);
            oJugadorRepository.save(oJugadorEntity1);
            return oJugadorRepository.count();
        } else {
            throw new ResourceNotFoundException("Unauthorized");
        }
    }
    */
}
