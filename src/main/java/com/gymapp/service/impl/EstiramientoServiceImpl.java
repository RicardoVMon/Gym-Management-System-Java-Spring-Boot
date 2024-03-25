package com.gymapp.service.impl;

import com.gymapp.dao.EstiramientoDao;
import com.gymapp.domain.Estiramiento;
import com.gymapp.service.EstiramientoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstiramientoServiceImpl implements EstiramientoService {

    @Autowired
    private EstiramientoDao estiramientoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Estiramiento> getTodos() {
         return estiramientoDao.findAll();
    }

    @Override
    public Estiramiento getEstiramientoPorId(Long idEstiramiento) {
        Optional<Estiramiento> estiramientoOptional = estiramientoDao.findById(idEstiramiento);
        return estiramientoOptional.orElse(null);
    }

}
