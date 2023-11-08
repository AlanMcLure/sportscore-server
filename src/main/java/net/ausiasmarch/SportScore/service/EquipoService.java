package net.ausiasmarch.SportScore.service;

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
//import net.ausiasmarch.SportScore.helper.DataGenerationHelper;
import net.ausiasmarch.SportScore.repository.EquipoRepository;
import net.ausiasmarch.SportScore.repository.JugadorRepository;

@Service
public class EquipoService {
    
    @Autowired
    EquipoRepository oEquipoRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    JugadorRepository oJugadorRepository;

    @Autowired
    JugadorService oJugadorService;

    public EquipoEntity get(Long id) {
        return oEquipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public Page<EquipoEntity> getPage(Pageable oPageable) {
        return oEquipoRepository.findAll(oPageable);
    }

    
}
