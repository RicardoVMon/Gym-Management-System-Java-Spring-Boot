package com.gymapp.controller.admin;

import com.gymapp.domain.Usuario;
import com.gymapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class UsuariosAdminController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/usuarios")
    public String usuariosAdmin(Model model) {

        List<Usuario> usuarios = usuarioService.encontrarUsuarioPorRolUsuario("ROLE_USER");
        
        model.addAttribute("usuarios", usuarios);

        return "admin/usuarios/usuarios";
    }
    
    // Handles the deletion of an object
    @GetMapping("/usuarios/eliminar/{idUsuario}")
    public String usuariosEliminar(@PathVariable("idUsuario") Long idUsuario) {
       usuarioService.eliminarUsuario(idUsuario);
        return "redirect:/admin/usuarios";
    }

}
