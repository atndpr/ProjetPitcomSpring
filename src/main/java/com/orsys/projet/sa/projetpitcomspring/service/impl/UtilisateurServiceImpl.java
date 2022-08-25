package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Resource
    private final UtilisateurDao utilisateurDao;


    @Override
    public Utilisateur authService(String email, String motDePassse) {
        Utilisateur utilisateur = utilisateurDao.findByEmailAndMotDePassse(email, motDePassse);
        if(utilisateur != null){
            utilisateur.setMotDePassse("");
        }
        return utilisateur;
    }

    @Override
    public Utilisateur inscriptService(Utilisateur utilisateur) {

        if(utilisateurDao.findByEmail(utilisateur.getEmail()) != null) {
            return null;
        }else {
            Utilisateur newUtilisateur = utilisateurDao.save(utilisateur);
            if(newUtilisateur != null){
                newUtilisateur.setMotDePassse("");
            }
            return newUtilisateur;
        }
    }
}
