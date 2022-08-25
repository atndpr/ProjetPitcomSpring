package com.orsys.projet.sa.projetpitcomspring.service.impl;
import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.dao.AnnonceDao;
import com.orsys.projet.sa.projetpitcomspring.service.AnnonceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnnonceServiceImpl implements AnnonceService {
    private AnnonceDao annonceDao;

    @Override
    public Annonce addAnnonce(Annonce annonce) {
        return annonceDao.save(annonce);
    }
}
