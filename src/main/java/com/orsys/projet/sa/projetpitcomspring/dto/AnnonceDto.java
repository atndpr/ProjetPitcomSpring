package com.orsys.projet.sa.projetpitcomspring.dto;

import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;
import com.orsys.projet.sa.projetpitcomspring.business.Zone;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AnnonceDto implements Serializable {
    private final LocalDateTime dateHeureCreation;
    private final LocalDateTime dateHeureDebut;
    private final LocalDateTime dateHeureFin;
    private final String contenu;
    private final String numeroCarte;
    private final int anneExpiration;
    private final byte moisExpiration;
    private final String cryptogramme;
    private final double montantRegleEnEuros;
    private final List<Long> idZones;
    private final List<Long> idTranchesHoraires;
}
