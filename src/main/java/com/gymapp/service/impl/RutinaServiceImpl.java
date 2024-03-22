package com.gymapp.service.impl;

import com.gymapp.dao.RutinaDao;
import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import com.gymapp.service.RutinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    RutinaDao rutinaDao;
    
    @Override
    public List<Rutina> encontrarRutinasPorUsuario(Usuario usuario) {
        List<Rutina> rutinas = rutinaDao.findByUsuario(usuario);
        return rutinas;
    }

}
