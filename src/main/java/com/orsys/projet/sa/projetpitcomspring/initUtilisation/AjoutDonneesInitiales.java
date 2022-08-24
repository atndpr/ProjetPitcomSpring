package com.orsys.projet.sa.projetpitcomspring.initUtilisation;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Arret;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.business.Zone;
import com.orsys.projet.sa.projetpitcomspring.dao.ArretDao;
import com.orsys.projet.sa.projetpitcomspring.dao.TrancheHoraireDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.dao.ZoneDao;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final ZoneDao zoneDao;
    private final ArretDao arretDao;
    private final TrancheHoraireDao trancheHoraireDao;
    private final UtilisateurDao utilisateurDao;


    @Override
    public void run(String... args) throws Exception {
        ajouterClients();
        ajouterAdministrateurs();

        ajouterZones();
        ajouterArrets();
    }

    private void ajouterArrets() {
        for( int i=1; i<=20; i++ ) {

            for( int j=0; j<5; ++j){
                Arret arret = new Arret();
                arret.setNom("Arret " + i);
                arret.setLongitude(i);
                arret.setLatitude(i);
                arret.setZone(zoneDao.findAll().get(j));
                arretDao.save(arret);
            }

        }


    }

    private void ajouterZones() {
        for (int i=1; i<=5; i++){
            Zone zone = new Zone();
            zone.setNom("Zone "+i );
            zoneDao.save(zone);
        }
    }

    private void ajouterClients() {
        Client client = new Client();
        client.setNom("MMT");
        client.setPrenom("Sulaiman");
        client.setEmail("client1@orsys.fr");
        client.setMotDePassse("12345678");
        client.setNumeroDeTelephone("0627216923");
        utilisateurDao.save(client);
    }

    private void ajouterAdministrateurs() {
        Administrateur administrateur = new Administrateur();
        administrateur.setNom("Delpierre");
        administrateur.setPrenom("Anthony");
        administrateur.setEmail("admin1@orsys.fr");
        administrateur.setMotDePassse("12345678");
        utilisateurDao.save(administrateur);
    }
}
