package com.gymapp.controller.user;

import com.gymapp.domain.Medida;
import com.gymapp.service.MedidaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class MedidasUserController {

    @Autowired
    private HttpSession session;
    
    @Autowired
    private MedidaService medidaService;
    

    @RequestMapping("/medidas")
    public String medidasUser(Model model) {
        Long idUsuario = (Long) session.getAttribute("id");
        Medida medidasUsuario = medidaService.getMedidasUsuario(idUsuario);
        
        model.addAttribute("medidasUsuario", medidasUsuario);
        
        return "user/medidas/medidas";

    }

    @PostMapping("/medidas")
    public String medidaGuardar(Medida medidaUsuario) {
        Long idUsuario = (Long) session.getAttribute("id");
        medidaService.actualizar(medidaUsuario, idUsuario);

        return "redirect:/user/medidas";
    }
    
    
    @GetMapping("/medidas/eliminar/{idMedida}")
    public String eliminarMedida(Medida medidaUsuario) {
        medidaService.borrarPorId(medidaUsuario.getIdMedida());
        
        return "redirect:/user/medidas";
    }
}