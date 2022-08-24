package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;

public interface UtilisateurService {
    Utilisateur authentifier(String email, String password);
    Utilisateur inscrire(Utilisateur utilisateur);
}
