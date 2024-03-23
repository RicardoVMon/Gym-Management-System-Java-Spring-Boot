package com.gymapp.service;

import com.gymapp.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> encontrarUsuarioPorRolUsuario(String nombreRol);
    
}
