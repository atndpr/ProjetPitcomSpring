package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.AdministrateurDao;
import com.orsys.projet.sa.projetpitcomspring.dao.ClientDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

    private final UtilisateurDao utilisateurDao;

    private final ClientDao clientDao;
    private final AdministrateurDao administrateurDao;

    @Override
    public Optional<Utilisateur> findUserById(Long id) {
        return utilisateurDao.findById(id);
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientDao.findById(id);
    }
    private final PasswordEncoder passwordEncoder;

    @Override
    public Client inscriptService(Client client) {
        if(utilisateurDao.findByEmail(client.getEmail()) != null) {
            return null;
        }else {
            Client newClient = new Client();
            newClient.setNom(client.getNom());
            newClient.setPrenom(client.getPrenom());
            newClient.setEmail(client.getEmail());
            newClient.setMotDePassse(passwordEncoder.encode(client.getMotDePassse()));
            newClient.setNumeroDeTelephone(client.getNumeroDeTelephone());
            utilisateurDao.save(newClient);
            return client;
        }
    }

    @Override
    public Utilisateur authService(String email, String motDePassse) {
        Utilisateur utilisateur = utilisateurDao.findByEmailAndMotDePassse(email, motDePassse);
        return utilisateur;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurDao.findByEmail(email);
        if(utilisateur == null){
            throw new UsernameNotFoundException("l'utilisateur n'existe pas");
        }
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(utilisateur);
        return new User(utilisateur.getEmail(), utilisateur.getMotDePassse(), grantedAuthorities);

    }

    private List<GrantedAuthority> getGrantedAuthorities(Utilisateur utilisateur) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        return authorities;
    }

    @Override
    public Optional<Administrateur> findAdminById(Long id) {
        return administrateurDao.findById(id);
    }
}
