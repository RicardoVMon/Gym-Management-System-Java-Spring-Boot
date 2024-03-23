package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "ejercicio_rutina")
public class EjercicioRutina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio_rutina")
    private Long idEjercicioRutina;

    @OneToOne
    @JoinColumn(name = "id_ejercicio")
    private Ejercicio ejercicio;

    @ManyToOne
    @JoinColumn(name = "id_rutina")
    private Rutina rutina;

    private int series;
    private int repeticiones;
    private Double pesoPrevio;
    private Double pesoActual;

    public EjercicioRutina() {
    }

    public EjercicioRutina(int series, int repeticiones, Double pesoPrevio, Double pesoActual) {
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoPrevio = pesoPrevio;
        this.pesoActual = pesoActual;
    }

}
