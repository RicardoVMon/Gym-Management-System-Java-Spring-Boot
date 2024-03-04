
package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuariosAdminController {
    
    @RequestMapping("/usuariosAdmin")
    public String page(Model model) {
        return "usuarios_admin";
    }
    
}
