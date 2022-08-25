package com.orsys.projet.sa.projetpitcomspring.service.impl;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.ClientDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDao utilisateurDao;
    private final ClientDao clientDao;

    @Override
    public Optional<Utilisateur> findUserById(Long id) {
        return utilisateurDao.findById(id);
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientDao.findById(id);
    }
}
