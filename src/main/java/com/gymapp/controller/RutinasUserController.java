package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutinasUserController {
    
    @RequestMapping("/rutinas-user")
    public String rutinasUser(Model model) {
        model.addAttribute("attribute", "value");
        return "rutinas-user";
    }
    
}
