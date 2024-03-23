package com.gymapp.service.impl;

import com.gymapp.dao.UsuarioDao;
import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> encontrarUsuarioPorRolUsuario(String nombreRol) {
        List<Usuario> usuarios = usuarioDao.findAllByRolNombre(nombreRol);
        return usuarios;
    }

}
