package com.orsys.projet.sa.projetpitcomspring.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TarifDto implements Serializable {
    private final double prixEnEuros;
    private final Long trancheHoraireId;
    private final Long zoneId;
}
