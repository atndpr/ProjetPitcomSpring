package com.orsys.projet.sa.projetpitcomspring.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateHeureCreation;
    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
    private String contenu;
    private String numeroCarte;
    private int anneExpiration;
    private byte moisExpiration;
    private String cryptogramme;
    private double montantRegleEnEuros;
    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<Zone> zones;
    @ManyToOne
    @JsonIgnore
    private Client client;
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<TrancheHoraire> tranchesHoraires;
}