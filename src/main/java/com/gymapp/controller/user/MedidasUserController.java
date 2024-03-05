package com.gymapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class MedidasUserController {
    
    @RequestMapping("/medidas")
    public String medidasUser(Model model) {
        return "user/medidas/medidas";
    }

}
