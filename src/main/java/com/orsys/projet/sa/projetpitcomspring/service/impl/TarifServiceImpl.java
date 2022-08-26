package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.Tarif;
import com.orsys.projet.sa.projetpitcomspring.dao.TarifDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.TarifService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TarifServiceImpl implements TarifService {
    private final TarifDao tarifDao;

    @Override
    public List<Tarif> findAllTarifs() {
        return tarifDao.findAll();
    }

    @Override
    public Tarif addTarif(Tarif tarif) {
        return tarifDao.save(tarif);
    }
}
