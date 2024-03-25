package com.gymapp.controller.admin;

import com.gymapp.domain.Ejercicio;
import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import com.gymapp.service.EjercicioRutinaService;
import com.gymapp.service.EjercicioService;
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
    public String rutinasAdminListadoUsuarios(Model model) {
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
    public String rutinasAdminListadoRutinasUsuario(Model model, Usuario usuario) {
        List<Rutina> rutinas = rutinaService.encontrarRutinasPorUsuario(usuario);
        model.addAttribute("rutinas", rutinas);
        model.addAttribute("idUsuario", usuario.getIdUsuario());
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
    public String rutinasAdminEliminarEjercicioRutina(@PathVariable("idRutina") Long idRutina,
            EjercicioRutina ejercicioRutina) {
        ejercicioRutinaService.EliminarEjercicioRutina(ejercicioRutina);
        return "redirect:/admin/rutinas/usuario/rutina/" + idRutina;
    }

    // Actualizar
    @PostMapping("/rutinas/usuario/rutina/{idRutina}/actualizar/{idEjercicioRutina}")
    public String rutinasAdminGuardarEjercicioRutina(@PathVariable("idRutina") Long idRutina,
            EjercicioRutina ejercicioRutina) {
        ejercicioRutinaService.GuardarEjercicioRutina(ejercicioRutina);
        return "redirect:/admin/rutinas/usuario/rutina/" + idRutina;
    }

    // Metodo para enviar datos a vista de agregar ejercicio a rutina
    @Autowired
    EjercicioService ejercicioService;

    @GetMapping("/rutinas/usuario/rutina/{idRutina}/agregar/")
    public String rutinasAdminListadoEjerciciosPorAgregar(Model model, @PathVariable("idRutina") Long idRutina) {
        List<Ejercicio> ejercicios = ejercicioService.getEjercicios();
        model.addAttribute("listaEjercicios", ejercicios);
        model.addAttribute("idRutina", idRutina);
        return "admin/rutinas/rutinas-usuario-rutina-agregar";
    }

    @GetMapping("/rutinas/usuario/rutina/{idRutina}/agregar/{idEjercicio}")
    public String rutinasAdminAgregarEjercicioRutina(Rutina rutina,
            Ejercicio ejercicio, EjercicioRutina ejercicioRutina) {
        ejercicio = ejercicioService.getEjercicioById(ejercicio);
        rutina = rutinaService.encontrarRutina(rutina);
        ejercicioRutina.setRutina(rutina);
        ejercicioRutina.setEjercicio(ejercicio);
        ejercicioRutina.setPesoActual(0.0d);
        ejercicioRutina.setPesoPrevio(0.0d);
        ejercicioRutinaService.GuardarEjercicioRutina(ejercicioRutina);
        return "redirect:/admin/rutinas/usuario/rutina/" + rutina.getIdRutina();
    }

    // Metodos para crear una rutina nueva
    @PostMapping("/rutinas/usuario/rutina/{idUsuario}/agregar/")
    public String rutinasAdminAgregarNuevaRutina(Usuario usuario, Rutina rutina) {
        rutina.setUsuario(usuario);
        rutinaService.guardarRutina(rutina);
        return "redirect:/admin/rutinas/usuario/" + usuario.getIdUsuario();
    }

    @GetMapping("/rutinas/usuario/{idUsuario}/rutina/{idRutina}/eliminar")
    public String rutinasAdminEliminarRutina(Rutina rutina, Usuario usuario) {
        rutinaService.eliminarRutina(rutina);
        return "redirect:/admin/rutinas/usuario/" + usuario.getIdUsuario();
    }
}
