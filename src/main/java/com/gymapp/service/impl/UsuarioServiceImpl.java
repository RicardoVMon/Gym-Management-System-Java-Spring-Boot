package com.gymapp.service.impl;

import com.gymapp.dao.RolDao;
import com.gymapp.dao.UsuarioDao;
import com.gymapp.domain.Rol;
import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioDetailsService;
import com.gymapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Override
    public List<Usuario> encontrarUsuarioPorRolUsuario(String nombreRol) {
        List<Usuario> usuarios = usuarioDao.findAllByRolNombre(nombreRol);
        return usuarios;
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long idUsuario) {
        usuarioDao.deleteById(idUsuario);
    }

    @Override
    public Usuario encontrarUsuarioPorId(Long idUsuario) {
        return usuarioDao.findById(idUsuario).orElse(null);
    }

    @Autowired
    RolDao rolDao;

    @Override
    public int save(Usuario usuario) {

        if (usuarioDao.findByUsername(usuario.getUsername()) != null
                || usuarioDao.findByEmail(usuario.getEmail()) != null) {
            return 0;
        }

        var codigo = new BCryptPasswordEncoder();
        usuario.setPassword(codigo.encode(usuario.getPassword()));
        usuarioDao.save(usuario);
        Rol rol = new Rol();
        rol.setIdUsuario(usuario.getIdUsuario());
        rol.setNombre("ROLE_USER");
        rolDao.save(rol);

        return 1;
    }
}
