package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.service.TrancheHoraireService;
import org.springframework.stereotype.Service;

@Service
public class TrancheHoraireServiceImpl implements TrancheHoraireService {
    private final TrancheHoraireService trancheHoraireService;

    public TrancheHoraireServiceImpl(TrancheHoraireService trancheHoraireService) {
        this.trancheHoraireService = trancheHoraireService;
    }
}
