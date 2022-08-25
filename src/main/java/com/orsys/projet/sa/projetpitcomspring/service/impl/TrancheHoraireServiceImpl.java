package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;
import com.orsys.projet.sa.projetpitcomspring.dao.TrancheHoraireDao;
import com.orsys.projet.sa.projetpitcomspring.service.TrancheHoraireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TrancheHoraireServiceImpl implements TrancheHoraireService {

    private final TrancheHoraireDao trancheHoraireDao;

    @Override
    public Optional<TrancheHoraire> findTrancheHoraireById(Long id) {
        return trancheHoraireDao.findById(id);
    }
}
