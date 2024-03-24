package com.gymapp.controller.user;

import com.gymapp.domain.EjercicioRutina;
import com.gymapp.domain.Rutina;
import com.gymapp.domain.Usuario;
import com.gymapp.service.EjercicioRutinaService;
import com.gymapp.service.RutinaService;
import com.gymapp.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class RutinasUserController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private EjercicioRutinaService ejercicioRutinaService;

    @GetMapping("/rutinas")
    public String rutinasUsuario(Model model, HttpSession session) {

        Long idUsuario = (Long) session.getAttribute("id");
        Usuario usuario = usuarioService.encontrarUsuarioPorId(idUsuario);
        List<Rutina> rutinas = rutinaService.encontrarRutinasPorUsuario(usuario);

        model.addAttribute("rutinas", rutinas);
        model.addAttribute("idUsuario", idUsuario);
        return "user/rutinas/rutinas";
    }

    @GetMapping("/rutinas/rutina/{idRutina}")
    public String rutinasUsuarioRutina(Model model, Rutina rutina) {

        rutina = rutinaService.encontrarRutina(rutina);
        List<EjercicioRutina> ejercicios = ejercicioRutinaService.encontrarEjercicioRutinaPorRutina(rutina);
        model.addAttribute("rutina", rutina);
        model.addAttribute("ejercicios", ejercicios);

        return "user/rutinas/rutina";
    }

    @PostMapping("/rutinas/rutina/{idRutina}/actualizar/{idEjercicioRutina}")
    public String rutinasUsuarioEjercicioGuardar(@PathVariable("idRutina") Long idRutina,
            EjercicioRutina ejercicioRutina) {

        ejercicioRutinaService.GuardarEjercicioRutina(ejercicioRutina);
        return "redirect:/user/rutinas/rutina/{idRutina}";
    }

}
