
package com.gymapp.dao;

import com.gymapp.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolDao extends JpaRepository<Rol, Long> {
    
    public void deleteByIdUsuario(Long idUsuario);
    
}
