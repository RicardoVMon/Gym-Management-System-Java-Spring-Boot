package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;
    private String genero;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    @OneToMany
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private List<Rutina> rutinas;

    public Usuario() {
    }

    public Usuario(String username, String password, String nombre, String apellidos, String email, String genero) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.genero = genero;
    }

}
