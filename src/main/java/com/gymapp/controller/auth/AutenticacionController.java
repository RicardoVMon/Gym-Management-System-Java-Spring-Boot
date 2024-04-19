package com.gymapp.controller.auth;

import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
            String mensaje = "Ha ocurrido un error, el nombre de usuario o correo ya está registrado";
            model.addAttribute("mensaje", mensaje);
            return "/autenticacion/registro";
        } else {
            String mensaje = "Usuario creado exitosamente. "
                    + "Por favor inicie sesión con sus credenciales para comenzar.";
            model.addAttribute("mensaje", mensaje);
            return "/autenticacion/login";
        }

    }

}
