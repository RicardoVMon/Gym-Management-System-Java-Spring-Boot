package com.gymapp.service.impl;

import com.gymapp.dao.EjercicioRutinaDao;
import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import com.gymapp.service.EjercicioRutinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioRutinaServiceImpl implements EjercicioRutinaService {

    @Autowired
    EjercicioRutinaDao ejercicioRutinaDao;

    @Override
    public List<EjercicioRutina> encontrarEjercicioRutinaPorRutina(Rutina rutina) {
        List<EjercicioRutina> ejercicios = ejercicioRutinaDao.findByRutina(rutina);
        return ejercicios;
    }

    @Override
    public void EliminarEjercicioRutina(EjercicioRutina ejercicioRutina) {
        ejercicioRutinaDao.delete(ejercicioRutina);
    }

    @Override
    public void GuardarEjercicioRutina(EjercicioRutina ejercicioRutina) {
        ejercicioRutinaDao.save(ejercicioRutina);
    }

}
