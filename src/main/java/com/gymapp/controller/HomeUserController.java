package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
Este controlador y "HomeUserController" se convertirán en un solo "HomeController" cuando 
aprendamos a manejar diferentes usuarios con condicionales de ThymeLeaf.
Más especificaciones en "homeUser.html" y "homeAdmin.html".
*/

@Controller
public class HomeUserController {
    
    @RequestMapping("/homeUser.html")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "homeUser";
    }
    
}
