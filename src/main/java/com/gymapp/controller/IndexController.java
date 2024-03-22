
package com.gymapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    
    // DE ESTA FORMA CONSEGUIMOS EL ID DE USUARIO ENTRE VISTAS
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        // Obtenemos el valor de la sesión "id"
        Long userId = (Long) session.getAttribute("id");
        // Agregamos el valor al modelo para pasarlo a la vista
        model.addAttribute("userId", userId);

        return "/index";
    }

}
