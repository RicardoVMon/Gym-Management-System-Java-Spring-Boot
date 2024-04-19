package com.gymapp.controller.auth;

import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutenticacionController {

    // Para retornar página de login
    @GetMapping("/login")
    public String login(Model model) {
        return "/autenticacion/login";
    }

    // Para retornar página de registro
    @GetMapping("/registro")
    public String registro(Model model) {
        return "/autenticacion/registro";
    }

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/registrar")
    public String registrar(Model model, Usuario usuario) {

        int estado = usuarioService.save(usuario);

        if (estado == 0) {
            return "/autenticacion/registro";
        } else {
            return "/autenticacion/login";
        }

    }

}
