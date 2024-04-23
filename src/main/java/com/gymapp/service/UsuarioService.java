package com.gymapp.service;

import com.gymapp.domain.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioService {

    public List<Usuario> encontrarUsuarioPorRolUsuario(String nombreRol);

    public void eliminarUsuario(Long idUsuario);

    public Usuario encontrarUsuarioPorId(Long idUsuario);
    
    public int save(Usuario usuario);
}
