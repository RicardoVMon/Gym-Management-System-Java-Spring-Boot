package com.gymapp.service;

import com.gymapp.domain.Ejercicio;

import java.util.List;

public interface EjercicioService {

    public List<Ejercicio> getEjercicios();

    public Ejercicio getEjercicioById(Ejercicio ejercicio);

    public void saveEjercicio(Ejercicio ejercicio);

    public void deleteEjercicio(Ejercicio ejercicio);
}
