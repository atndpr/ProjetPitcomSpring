package com.orsys.projet.sa.projetpitcomspring.initUtilisation;

import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final UtilisateurDao utilisateurDao;


    @Override
    public void run(String... args) throws Exception {
        ajouterUtilisateurs();
    }

    private void ajouterUtilisateurs() {
        if(utilisateurDao.count()==0){
            Client client = new Client();
            client.setNom("MMT");
            client.setPrenom("Sulaiman");
            client.setEmail("client1@orsys.fr");
            client.setMotDePassse("12345678");
            client.setNumeroDeTelephone("0627216923");
            utilisateurDao.save(client);
        }
        utilisateurDao.findAll();
    }
}
