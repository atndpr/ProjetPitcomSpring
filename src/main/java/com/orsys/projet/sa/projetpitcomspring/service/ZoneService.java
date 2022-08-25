package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Zone;

import java.util.List;
import java.util.Optional;

public interface ZoneService {
    List<Zone> findAllZones();
    Optional<Zone> findZoneById(Long id);
}
