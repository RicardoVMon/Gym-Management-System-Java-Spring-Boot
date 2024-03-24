package com.gymapp.controller.admin;

import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import com.gymapp.service.EjercicioRutinaService;
import com.gymapp.service.RutinaService;
import com.gymapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class RutinasAdminController {
    
    @Autowired
    UsuarioService usuarioService;
    
    // Metodo para encontrar todos los usuarios con rol USER
    
    @GetMapping("/rutinas")
    public String rutinasAdmin(Model model) {
        List<Usuario> usuarios = usuarioService.encontrarUsuarioPorRolUsuario("ROLE_USER");
        model.addAttribute("usuarios", usuarios);
        return "admin/rutinas/rutinas";
    }
    
    @Autowired
    RutinaService rutinaService;
    
    @Autowired
    EjercicioRutinaService ejercicioRutinaService;
    
    // Metodo para conseguir todas las rutinas de un usuario segun su id
    
    @GetMapping("/rutinas/usuario/{idUsuario}")
    public String rutinasAdminUsuario(Model model, Usuario usuario) {
        List<Rutina> rutinas = rutinaService.encontrarRutinasPorUsuario(usuario);
        model.addAttribute("rutinas", rutinas);
        return "admin/rutinas/rutinas-usuario";
    }
    
    // Metodo para enviar todos los ejercicios de la rutina segun el id de la rutina
    
    @GetMapping("/rutinas/usuario/rutina/{idRutina}")
    public String rutinasAdminRutina(Model model, Rutina rutina) {
        rutina = rutinaService.encontrarRutina(rutina);
        List<EjercicioRutina> ejercicios = ejercicioRutinaService.encontrarEjercicioRutinaPorRutina(rutina);
        model.addAttribute("ejercicios", ejercicios);
        model.addAttribute("rutina", rutina);
        return "admin/rutinas/rutinas-usuario-rutina";
    }
    
    // CRUD de Ejercicios
    
    // Eliminar
    @GetMapping("/rutinas/usuario/rutina/{idRutina}/eliminar/{idEjercicioRutina}")
    public String rutinasAdminEjercicioEliminar(@PathVariable("idRutina") Long idRutina, 
            EjercicioRutina ejercicioRutina) {
        ejercicioRutinaService.EliminarEjercicioRutina(ejercicioRutina);
        return "redirect:/admin/rutinas/usuario/rutina/" + idRutina;
    }
    
    // Actualizar
    @PostMapping("/rutinas/usuario/rutina/{idRutina}/actualizar/{idEjercicioRutina}")
    public String rutinasAdminEjercicioGuardar(@PathVariable("idRutina") Long idRutina, 
            EjercicioRutina ejercicioRutina) {
        ejercicioRutinaService.GuardarEjercicioRutina(ejercicioRutina);
        return "redirect:/admin/rutinas/usuario/rutina/" + idRutina;
    }
    
    @GetMapping("/rutinas/usuario/rutina/agregar")
    public String rutinasAdminEjercicio(Model model) {
        return "admin/rutinas/rutinas-usuario-rutina-agregar";
    }

}
