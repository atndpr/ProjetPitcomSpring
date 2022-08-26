package com.orsys.projet.sa.projetpitcomspring.service.impl;
import com.orsys.projet.sa.projetpitcomspring.business.Annonce;


import com.orsys.projet.sa.projetpitcomspring.dao.AnnonceDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.AnnonceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnnonceServiceImpl implements AnnonceService {

    private AnnonceDao annonceDao;

    @Override
    public Annonce addAnnonce(Annonce annonce) {
        return annonceDao.save(annonce);
    }

    @Override
    public List<Annonce> recupererAnnonces() {
        return annonceDao.findAll();
    }

    @Override
    public List<Annonce> recupererAnnoncesClient(String clientId) {
        return annonceDao.findByClientId(clientId);
    }
}
