package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;

import java.util.Optional;

public interface TrancheHoraireService {
    Optional<TrancheHoraire> findTrancheHoraireById(Long id);
}
