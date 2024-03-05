package com.gymapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class EstiramientosUserController {
    
    @GetMapping("/estiramientos")
    public String estiramientosUser(Model model) {
        return "user/estiramientos/estiramientos";
    }
    
    @GetMapping("/estiramientos/estiramientos")
    public String estiramientosUserEstiramientos(Model model) {
        return "user/estiramientos/videos/estiramientos";
    }
    
    @GetMapping("/estiramientos/flexibilidad")
    public String estiramientosUserFlexibilidad(Model model) {
        return "user/estiramientos/videos/flexibilidad";
    }
    
    @GetMapping("/estiramientos/movilidad")
    public String estiramientosUserMovilidad(Model model) {
        return "user/estiramientos/videos/movilidad";
    }
    
    @GetMapping("/estiramientos/yoga")
    public String estiramientosUserYoga(Model model) {
        return "user/estiramientos/videos/yoga";
    }
}

