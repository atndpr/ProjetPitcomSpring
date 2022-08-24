package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmailAndMotDePassse(String email,String motDePassse);
    Utilisateur findByEmail(String email);
}
