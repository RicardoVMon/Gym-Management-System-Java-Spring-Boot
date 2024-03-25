package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "ejercicio")
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Long idEjercicio;

    private String nombre;

    public Ejercicio() {
    }

    public Ejercicio(String nombre) {
        this.nombre = nombre;
    }

}
