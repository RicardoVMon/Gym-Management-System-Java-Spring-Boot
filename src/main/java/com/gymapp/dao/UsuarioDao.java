package com.gymapp.dao;

import com.gymapp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/*Funciones requeridas por DAO de ejercicios: Leer y Eliminar (Por confirmar)*/
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
