package com.gymapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class EjerciciosAdminController {
    
    @RequestMapping("/ejercicios")
    public String ejerciciosAdmin(Model model) {
        return "admin/ejercicios/ejercicios";
    }
    
}
