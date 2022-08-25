package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.Zone;
import com.orsys.projet.sa.projetpitcomspring.dao.ZoneDao;
import com.orsys.projet.sa.projetpitcomspring.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ZoneServiceImpl implements ZoneService {
    private ZoneDao zoneDao;

    @Override
    public List<Zone> findAllZones() {
        return zoneDao.findAll();
    }

    @Override
    public Optional<Zone> findZoneById(Long id) {
        return zoneDao.findById(id);
    }
}
