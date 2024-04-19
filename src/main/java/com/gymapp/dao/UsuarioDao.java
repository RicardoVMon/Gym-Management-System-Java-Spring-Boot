package com.gymapp.dao;

import com.gymapp.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*Funciones requeridas por DAO de ejercicios: Leer y Eliminar (Por confirmar)*/
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    
    Usuario findByEmail(String email);
    
    @Query(value = "SELECT DISTINCT u.* FROM gymapp.usuario u " +
            "INNER JOIN gymapp.rol r ON u.id_usuario = r.id_usuario " +
            "WHERE r.nombre = :nombreRol", nativeQuery = true)
    List<Usuario> findAllByRolNombre(@Param("nombreRol") String nombreRol);
    
}
