package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.dao.TarifDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.TarifService;
import org.springframework.stereotype.Service;

@Service
public class TarifServiceImpl implements TarifService {
    private final TarifDao tarifDao;

    public TarifServiceImpl(TarifDao tarifDao) {
        this.tarifDao = tarifDao;
    }
}
