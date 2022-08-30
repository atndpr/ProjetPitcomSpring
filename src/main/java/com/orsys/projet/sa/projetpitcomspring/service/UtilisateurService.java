package com.orsys.projet.sa.projetpitcomspring.service;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    //Login
    Utilisateur authService(String email, String motDePassse);
    //register
    Utilisateur inscriptService(Utilisateur utilisateur);
    Client inscriptService(Client client);

    Optional<Utilisateur> findUserById(Long id);

    Utilisateur findUser(String email, String motDePassse);

    Optional<Client> findClientById(Long id);

    Optional<Administrateur> findAdminById(Long id);



    List<Utilisateur> recupererUtilisateurs(); //

}


