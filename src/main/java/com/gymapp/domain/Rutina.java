package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "rutina")
public class Rutina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Long idRutina;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @OneToMany
    @JoinColumn(name = "id_rutina", insertable = false, updatable = false)
    private List<EjercicioRutina> ejercicios;

    public Rutina() {
    }

    public Rutina(String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

}
