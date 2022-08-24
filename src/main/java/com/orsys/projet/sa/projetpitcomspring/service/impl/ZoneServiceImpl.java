package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.dao.ZoneDao;
import com.orsys.projet.sa.projetpitcomspring.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ZoneServiceImpl implements ZoneService {
    private ZoneDao zoneDao;
}
