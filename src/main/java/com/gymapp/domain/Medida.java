package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "medida")
public class Medida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medida")
    private Long idMedida;

    private Double peso;
    private Double grasa;
    private Double cuello;
    private Double hombros;
    private Double bicepIzquierdo;
    private Double bicepDerecho;
    private Double cintura;
    private Double cadera;
    private Double musloIzquierdo;
    private Double musloDerecho;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Medida() {
        this.peso = 0.0;
        this.grasa = 0.0;
        this.cuello = 0.0;
        this.hombros = 0.0;
        this.bicepIzquierdo = 0.0;
        this.bicepDerecho = 0.0;
        this.cintura = 0.0;
        this.cadera = 0.0;
        this.musloIzquierdo = 0.0;
        this.musloDerecho = 0.0;
    }

    public Medida(Double peso, Double grasa, Double cuello, Double hombros, Double bicepIzquierdo, Double bicepDerecho, Double cintura, Double cadera, Double musloIzquierdo, Double musloDerecho, Usuario usuario) {
        this.peso = peso;
        this.grasa = grasa;
        this.cuello = cuello;
        this.hombros = hombros;
        this.bicepIzquierdo = bicepIzquierdo;
        this.bicepDerecho = bicepDerecho;
        this.cintura = cintura;
        this.cadera = cadera;
        this.musloIzquierdo = musloIzquierdo;
        this.musloDerecho = musloDerecho;
        this.usuario = usuario;
    }

}
