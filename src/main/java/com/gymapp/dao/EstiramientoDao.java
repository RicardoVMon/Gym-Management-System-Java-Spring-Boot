package com.gymapp.dao;

import com.gymapp.domain.Estiramiento;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/*Funciones requeridas por DAO de ejercicios: Leer toda su informacion*/
public interface EstiramientoDao extends JpaRepositoryImplementation<Estiramiento, Long> {

}
