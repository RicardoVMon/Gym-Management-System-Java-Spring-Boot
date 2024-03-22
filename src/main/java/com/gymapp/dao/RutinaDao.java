package com.gymapp.dao;

import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/*Funciones requeridas por DAO de rutinas: CRUD*/
public interface RutinaDao extends JpaRepositoryImplementation<Rutina, Long> {

    List<Rutina> findByUsuario(Usuario usuario);

}
