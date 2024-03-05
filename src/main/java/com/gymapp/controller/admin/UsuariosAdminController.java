package com.gymapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class UsuariosAdminController {
    
    @RequestMapping("/usuarios")
    public String usuariosAdmin(Model model) {
        return "admin/usuarios/usuarios";
    }
    
}
