package net.ausiasmarch.SportScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import net.ausiasmarch.SportScore.entity.PartidoEntity;
import net.ausiasmarch.SportScore.entity.EquipoEntity;
import net.ausiasmarch.SportScore.entity.JugadorEntity;
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.EquipoRepository;
import net.ausiasmarch.SportScore.repository.JugadorRepository;
import net.ausiasmarch.SportScore.repository.PartidoRepository;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository oPartidoRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    EquipoRepository oEquipoRepository;

    @Autowired
    SessionService oSessionService;

    public PartidoEntity get(Long id) {
        return oPartidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido not found"));
    }

    public Page<PartidoEntity> getPage(Pageable oPageable, Long equipoId) {
        if (equipoId == 0) {
            return oPartidoRepository.findAll(oPageable);
        } else {
            return oPartidoRepository.findByEquipoLocalIdOrEquipoVisitanteId(equipoId, equipoId, oPageable);
        }
    }

    @Transactional
    public Long create(PartidoEntity oPartidoEntity) {
        oSessionService.onlyAdmins();
        oPartidoEntity.setId(null);
        return oPartidoRepository.save(oPartidoEntity).getId();
    }

    @Transactional
    public PartidoEntity update(PartidoEntity oPartidoEntityToSet) {
        PartidoEntity oPartidoEntityFromDatabase = this.get(oPartidoEntityToSet.getId());
        oSessionService.onlyAdminsOrUsersWithIsOwnData(oPartidoEntityFromDatabase.getId());
        if (oSessionService.isUser()) {
            JugadorEntity oJugadorEntity = oSessionService.getSessionUser();
            if (oJugadorEntity.getEquipo() != null
                    && (oJugadorEntity.getEquipo().getId().equals(oPartidoEntityToSet.getEquipoLocal().getId())
                            || oJugadorEntity.getEquipo().getId()
                                    .equals(oPartidoEntityToSet.getEquipoVisitante().getId()))) {
                return oPartidoRepository.save(oPartidoEntityToSet);
            } else {
                throw new ResourceNotFoundException("Unauthorized");
            }
        } else {
            return oPartidoRepository.save(oPartidoEntityToSet);
        }
    }

    @Transactional
    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oPartidoRepository.deleteById(id);
        return id;
    }

    public PartidoEntity getOneRandom() {
        oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * oPartidoRepository.count()), 1);
        return oPartidoRepository.findAll(oPageable).getContent().get(0);
    }

    // Falta hacer esta función bien con el DataGenerator
    @Transactional
    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            /*
             * oPartidoRepository
             * .save(new PartidoEntity(DataGenerationHelper.getSpeech(1),
             * oUserService.getOneRandom()));
             */
        }
        return oPartidoRepository.count();
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oPartidoRepository.deleteAll();
        oPartidoRepository.resetAutoIncrement();
        oPartidoRepository.flush();
        return oPartidoRepository.count();
    }
}
