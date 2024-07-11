package com.example.stage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Kosu implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Integer idKosu;
    private  String horaire;
    private  String serieReference;
    private Integer effectifPresent;
    private Integer tempsNetDeTravail;
    private Integer nok;
    private float coefficient;
    private  float kosuEquivalent;
    @ManyToOne
    User user;


}
