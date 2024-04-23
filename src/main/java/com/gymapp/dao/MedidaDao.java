package com.gymapp.dao;

import com.gymapp.domain.Medida;
import com.gymapp.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/*Funciones requeridas por DAO de medidas: CRUD*/
public interface MedidaDao extends JpaRepositoryImplementation<Medida, Long> {

    Medida findByUsuario(Usuario usuario);

    @Query("SELECT m FROM Medida m WHERE m.usuario.idUsuario = ?1")
    Medida findByIdUsuario(Long idUsuario);

    void deleteByUsuario(Usuario usuario);

}
