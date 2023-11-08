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
import net.ausiasmarch.SportScore.exception.ResourceNotFoundException;
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.EquipoRepository;
import net.ausiasmarch.SportScore.repository.JugadorRepository;
import net.ausiasmarch.SportScore.repository.PartidoRepository;

public class PartidoService {

    @Autowired
    PartidoRepository oPartidoRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    EquipoRepository oEquipoRepository;

    public PartidoEntity get(Long id) {
        return oPartidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido not found"));
    }

    public Page<PartidoEntity> getPage(Pageable oPageable) {
        return oPartidoRepository.findAll(oPageable);
    }
}
