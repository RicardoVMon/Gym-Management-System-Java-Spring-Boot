package com.gymapp.service;

import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import java.util.List;

public interface EjercicioRutinaService {

    public List<EjercicioRutina> encontrarEjercicioRutinaPorRutina(Rutina rutina);

    public void EliminarEjercicioRutina(EjercicioRutina ejercicioRutina);

    public void GuardarEjercicioRutina(EjercicioRutina ejercicioRutina);

}
