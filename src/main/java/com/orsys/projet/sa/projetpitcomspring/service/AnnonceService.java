package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import java.util.List;

public interface AnnonceService {
    Annonce addAnnonce(Annonce annonce);
    List<Annonce> recupererAnnonces();
    List<Annonce> recupererAnnoncesClient(String clientId);
}
