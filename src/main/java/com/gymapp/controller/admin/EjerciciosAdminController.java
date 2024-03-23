package com.gymapp.controller.admin;

import com.gymapp.domain.Ejercicio;
import com.gymapp.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class EjerciciosAdminController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/ejercicios")
    public String ejerciciosAdmin(Model model) {
        List<Ejercicio> ejercicios = ejercicioService.getEjercicios();
        model.addAttribute("listaEjercicios", ejercicios);
        return "admin/ejercicios/ejercicios";
    }

    @PostMapping("/ejercicios/agregar")
    public String guardarEjercicio(Ejercicio ejercicio) {
        ejercicioService.saveEjercicio(ejercicio);
        return "redirect:/admin/ejercicios";
    }

    @PostMapping("/ejercicios/editar/{idEjercicio}")  
    public String modificarEjercicio(Ejercicio ejercicio) {
        ejercicioService.saveEjercicio(ejercicio);
        return "/admin/ejercicios/ejercicios-modifica";
    }
    
    @GetMapping("/ejercicios/editar/{idEjercicio}")  
    public String modificarEjercicios(Ejercicio ejercicio, Model model) {
       ejercicio = ejercicioService.getEjercicioById(ejercicio);
       model.addAttribute("ejercicio", ejercicio);
        return "/admin/ejercicios/ejercicios-modifica";
    }

    @GetMapping("/ejercicios/eliminar/{idEjercicio}") 
    public String eliminarEjercicio(Ejercicio ejercicio) {
         ejercicioService.deleteEjercicio(ejercicio);
        return "redirect:/admin/ejercicios";
    }
}
