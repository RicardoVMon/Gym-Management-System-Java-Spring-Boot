package com.gymapp.dao;

import com.gymapp.domain.Ejercicio;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/*Funciones requeridas por DAO de ejercicios: CRUD*/
public interface EjercicioDao extends JpaRepositoryImplementation<Ejercicio, Long> {

}
