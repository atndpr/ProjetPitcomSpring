package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Tarif;

import java.util.List;

public interface TarifService {
    List<Tarif> findAllTarifs();
    Tarif addTarif(Tarif tarif);
}
