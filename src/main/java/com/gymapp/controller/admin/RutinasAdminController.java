package com.gymapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class RutinasAdminController {

    @GetMapping("/rutinas")
    public String rutinasAdmin(Model model) {
        return "admin/rutinas/rutinas";
    }
    
    @GetMapping("/rutinas/usuario")
    public String rutinasAdminUsuario(Model model) {
        return "admin/rutinas/rutinas-usuario";
    }
    
    @GetMapping("/rutinas/usuario/rutina")
    public String rutinasAdminRutina(Model model) {
        return "admin/rutinas/rutinas-usuario-rutina";
    }
    
    @GetMapping("/rutinas/usuario/rutina/agregar")
    public String rutinasAdminEjercicio(Model model) {
        return "admin/rutinas/rutinas-usuario-rutina-agregar";
    }

}
