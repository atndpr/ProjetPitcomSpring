package com.orsys.projet.sa.projetpitcomspring.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prixEnEuros;
    @ManyToOne
    private Administrateur administrateur;
    @ManyToOne
    private TrancheHoraire trancheHoraire;
    @ManyToOne
    private Zone zone;
}
