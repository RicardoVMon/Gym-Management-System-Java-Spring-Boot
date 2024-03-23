package com.gymapp.service.impl;

import com.gymapp.dao.EjercicioDao;
import com.gymapp.domain.Ejercicio;
import com.gymapp.service.EjercicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioServiceImpl implements EjercicioService {

    @Autowired
    private EjercicioDao ejercicioDao;

    @Override
    public List<Ejercicio> getEjercicios() {
        return ejercicioDao.findAll();
    }

    @Override
    public Ejercicio getEjercicioById(Ejercicio ejercicio) {
        return ejercicioDao.findById(ejercicio.getIdEjercicio()).orElse(null);
    }

    @Override
    public void saveEjercicio(Ejercicio ejercicio) {
        ejercicioDao.save(ejercicio);
    }

    @Override
    public void deleteEjercicio(Ejercicio ejercicio) {
        ejercicioDao.delete(ejercicio);
    }
}
