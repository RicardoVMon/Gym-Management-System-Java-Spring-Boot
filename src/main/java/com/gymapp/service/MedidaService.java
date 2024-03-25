package com.gymapp.service;

import com.gymapp.domain.Medida;
import com.gymapp.domain.Usuario;


public interface MedidaService {

    public Medida getMedida(Long idMedida);
    
    public Medida getMedidasUsuario(Usuario usuario);
    
    public Medida getMedidasUsuario(Long idUsuario);

    void delete(Medida medida);

    void save(Medida medida);
    
    void actualizar(Medida medida, Long idUsuario);
    
    void borrarPorId(Long idMedida);

}
