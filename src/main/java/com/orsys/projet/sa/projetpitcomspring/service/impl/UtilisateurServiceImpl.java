package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDao utilisateurDao;

    @Override
    public Utilisateur authentifier(String email, String motDePassse) {
        Utilisateur utilisateur = utilisateurDao.findByEmailAndMotDePassse(email, motDePassse);
        if (utilisateur == null) {
            return null;
        }
        return null;
    }

    @Override
    public Utilisateur inscrire(Utilisateur utilisateur) {
        String email = utilisateur.getEmail();
        return null;
    }
}
