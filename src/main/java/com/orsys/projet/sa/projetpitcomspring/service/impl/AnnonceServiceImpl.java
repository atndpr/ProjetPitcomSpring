package com.orsys.projet.sa.projetpitcomspring.service.impl;
import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
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
    //private UtilisateurDao utilisateurDao;

    @Override
    public List<Annonce> recupererAnnonces() {
        return annonceDao.findAll();
    }

    @Override
    public List<Annonce> recupererAnnoncesClient(String clientId) {
        return annonceDao.findByClientId(clientId);
    }
}
