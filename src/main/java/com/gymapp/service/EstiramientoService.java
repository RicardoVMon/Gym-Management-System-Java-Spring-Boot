package com.gymapp.service;

import com.gymapp.domain.Estiramiento;
import java.util.List;

public interface EstiramientoService {
    
    public List<Estiramiento> getTodos();
    
    public Estiramiento getEstiramientoPorId(Long idEstiramiento);
}
