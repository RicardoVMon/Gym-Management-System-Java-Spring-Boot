package com.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutinasAdminController {

    @RequestMapping("/rutinas-admin")
    public String rutinasAdmin(Model model) {
        model.addAttribute("attribute", "value");
        return "rutinas-admin";
    }

}
