package com.gymapp.dao;

import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/*Funciones requeridas por DAO de ejercicioRutina: CRUD*/
public interface EjercicioRutinaDao extends JpaRepository<EjercicioRutina, Long> {

    List<EjercicioRutina> findByRutina(Rutina rutina);

}
