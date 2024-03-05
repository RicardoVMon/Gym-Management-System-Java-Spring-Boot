package com.gymapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class RutinasUserController {
    
    @RequestMapping("/rutinas")
    public String rutinasUser(Model model) {
        return "user/rutinas/rutinas";
    }
    
}
