package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RutinasAdminController {

    @GetMapping("/rutinasAdmin")
    public String rutinasAdmin(Model model) {
        return "/rutinas-admin/rutinas-1";
    }
    
    @GetMapping("/rutinasAdmin/usuario")
    public String rutinasAdminUsuario(Model model) {
        return "/rutinas-admin/rutinas-2";
    }
    
    @GetMapping("/rutinasAdmin/usuario/rutina")
    public String rutinasAdminRutina(Model model) {
        return "/rutinas-admin/rutinas-3";
    }
    
    @GetMapping("/rutinasAdmin/usuario/rutina/agregarEjercicio")
    public String rutinasAdminEjercicio(Model model) {
        model.addAttribute("attribute", "value");
        return "/rutinas-admin/rutinas-4";
    }

}
