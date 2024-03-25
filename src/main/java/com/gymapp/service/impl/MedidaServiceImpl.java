package com.gymapp.service.impl;

import com.gymapp.dao.MedidaDao;
import com.gymapp.dao.UsuarioDao;
import com.gymapp.domain.Medida;
import com.gymapp.domain.Usuario;
import com.gymapp.service.MedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedidaServiceImpl implements MedidaService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private MedidaDao medidaDao;

    @Override
    @Transactional
    public Medida getMedida(Long idMedida) {
        return medidaDao.findById(idMedida).orElse(null);
    }

    @Override
    public void delete(Medida medida) {
       medidaDao.delete(medida);
    }

    @Override
    public void save(Medida medida) {
        medidaDao.save(medida);
    }

    @Override
    public Medida getMedidasUsuario(Usuario usuario) {
        return medidaDao.findByUsuario(usuario);
    }

    @Override
    public Medida getMedidasUsuario(Long idUsuario) {
        Medida medidasUsuario = medidaDao.findByIdUsuario(idUsuario);
        
        if (medidasUsuario == null) { 
            medidasUsuario = new Medida();
            
            Usuario usuario = usuarioDao.findById(idUsuario).orElse(null);
            if (usuario != null) {
                medidasUsuario.setUsuario(usuario);
            }
        }
        
        return medidasUsuario;
    }
    
    @Override
    public void actualizar(Medida medida, Long idUsuario) {
        if (medida.getUsuario() == null) {
            Usuario usuario = usuarioDao.findById(idUsuario).orElse(null);
            
            if (usuario != null) {
                medida.setUsuario(usuario);
            }
        }
        
        medidaDao.save(medida);
    }

    @Override
    public void borrarPorId(Long idMedida) {
        medidaDao.deleteById(idMedida);
    }
}
