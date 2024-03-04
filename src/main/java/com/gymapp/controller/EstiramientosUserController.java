/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Fio
 */
@Controller
@RequestMapping("/estiramientos/")
public class EstiramientosUserController {
    
    @GetMapping("/inicio")
    public String principal(Model model) {
        model.addAttribute("attribute", "value");
        return "estiramientos_user";
    }
    
    @GetMapping("/videoEstiramientos")
    public String estiramientos(Model model) {
        model.addAttribute("attribute", "value");
        return "/estiramientos/video_estiramientos";
    }
    
    @GetMapping("/videoFlexibilidad")
    public String flexibilidad(Model model) {
        model.addAttribute("attribute", "value");
        return "/estiramientos/video_flexibilidad";
    }
    
    @GetMapping("/videoMovilidad")
    public String movilidad(Model model) {
        model.addAttribute("attribute", "value");
        return "/estiramientos/video_movilidad";
    }
    
    @GetMapping("/videoYoga")
    public String yoga(Model model) {
        model.addAttribute("attribute", "value");
        return "/estiramientos/video_yoga";
    }
}

