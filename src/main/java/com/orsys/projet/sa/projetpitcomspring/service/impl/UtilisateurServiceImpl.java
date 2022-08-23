package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
}
