package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.business.Client;

import java.util.List;

public interface AnnonceService {
    List<Annonce> recupererAnnonces();

    List<Annonce> recupererAnnoncesClient(String clientId);
}
