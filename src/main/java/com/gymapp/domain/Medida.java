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
