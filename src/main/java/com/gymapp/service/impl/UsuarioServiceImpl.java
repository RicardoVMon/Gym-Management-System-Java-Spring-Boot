package com.gymapp.service.impl;

import com.gymapp.dao.EjercicioRutinaDao;
import com.gymapp.dao.MedidaDao;
import com.gymapp.dao.RolDao;
import com.gymapp.dao.RutinaDao;
import com.gymapp.dao.UsuarioDao;
import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rol;
import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    RolDao rolDao;

    @Autowired
    RutinaDao rutinaDao;

    @Autowired
    EjercicioRutinaDao ejercicioRutinaDao;
    
    @Autowired
    MedidaDao medidaDao;

    @Override
    public List<Usuario> encontrarUsuarioPorRolUsuario(String nombreRol) {
        List<Usuario> usuarios = usuarioDao.findAllByRolNombre(nombreRol);
        return usuarios;
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long idUsuario) {

        // Eliminar el rol
        rolDao.deleteByIdUsuario(idUsuario);

        // Eliminar las rutinas
        List<Rutina> rutinas = rutinaDao.findByUsuario(usuarioDao.findById(idUsuario).orElse(null));
        for (Rutina rutina : rutinas) {
            // Eliminar los ejercicios dentro de la rutina si los hay
            List<EjercicioRutina> ejercicios = ejercicioRutinaDao.findByRutina(rutina);
            if (!ejercicios.isEmpty()) {
                for (EjercicioRutina ejercicio : ejercicios) {
                    ejercicioRutinaDao.delete(ejercicio);
                }
            }
            // Eliminar la rutina
            rutinaDao.delete(rutina);
        }

        // Eliminar las medidas
        medidaDao.deleteByUsuario(usuarioDao.findById(idUsuario).orElse(null));
        
        // Eliminar el usuario
        usuarioDao.deleteById(idUsuario);
    }

    @Override
    public Usuario encontrarUsuarioPorId(Long idUsuario) {
        return usuarioDao.findById(idUsuario).orElse(null);
    }

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
