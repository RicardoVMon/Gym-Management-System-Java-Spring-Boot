package com.gymapp.controller.user;

import com.gymapp.domain.Estiramiento;
import com.gymapp.service.EstiramientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class EstiramientosUserController {
    
    @Autowired
    private EstiramientoService estiramientoService;
    
    @GetMapping("/estiramientos")
    public String estiramientosUser(Model model) {
        List<Estiramiento> estiramientos = estiramientoService.getTodos();
        model.addAttribute("estiramientos", estiramientos);
        
        return "user/estiramientos/estiramientos";
    }
    
    @GetMapping("/videos/{idEstiramiento}")
    public String estiramientosUserEstiramientos(@PathVariable Long idEstiramiento, Model model) {
        Estiramiento estiramiento = estiramientoService.getEstiramientoPorId(idEstiramiento);
        model.addAttribute("estiramiento", estiramiento);
        
        return "user/estiramientos/videos";
    }
}

