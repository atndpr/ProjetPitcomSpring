package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;

public interface UtilisateurService {
    Utilisateur authService(String email, String password);
    Utilisateur inscriptService(Utilisateur utilisateur);
}
