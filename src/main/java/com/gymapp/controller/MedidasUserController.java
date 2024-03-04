package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedidasUserController {
    
    @RequestMapping("/medidas-user")
    public String page(Model model) {
        return "medidas-user";
    }

}
