package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import java.util.Optional;

public interface UtilisateurService {
    Optional<Utilisateur> findUserById(Long id);
    Optional<Client> findClientById(Long id);
}
