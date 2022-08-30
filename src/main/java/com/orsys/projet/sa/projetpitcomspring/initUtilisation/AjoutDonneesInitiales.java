package com.orsys.projet.sa.projetpitcomspring.initUtilisation;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.business.Arret;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;
import com.orsys.projet.sa.projetpitcomspring.business.Zone;

import com.orsys.projet.sa.projetpitcomspring.dao.AnnonceDao;
import com.orsys.projet.sa.projetpitcomspring.dao.ArretDao;
import com.orsys.projet.sa.projetpitcomspring.dao.TrancheHoraireDao;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.dao.ZoneDao;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final ZoneDao zoneDao;
    private final ArretDao arretDao;
    private final TrancheHoraireDao trancheHoraireDao;
    private final UtilisateurDao utilisateurDao;
    private final AnnonceDao annonceDao;


    @Override
    public void run(String... args) throws Exception {
        ajouterClients();
        ajouterAdministrateurs();

        ajouterZones();
        ajouterArrets();
        ajouterTranchesHoraires();

        ajouterAnnonces();
    }

    private void ajouterAnnonces() {
        for (int i=1; i<=5; i++){
            Annonce annonce = new Annonce();
            annonce.setDateHeureCreation(LocalDateTime.now());
            annonce.setDateHeureDebut(LocalDateTime.now());
            annonce.setDateHeureFin(LocalDateTime.now());
            annonce.setContenu("contenu_"+i);
            annonce.setNumeroCarte("numeroCarte_"+i);
            annonce.setCryptogramme("cryptogramme_"+i);
            annonce.setAnneExpiration(2030+i);
            annonce.setMoisExpiration((byte)i);
            annonce.setCryptogramme("cryptogramme_"+i);

            /*Client client = new Client();
            annonce.setClient(client);

           Add zones
            List<Zone> zones = new ArrayList<Zone>();
            Zone zone = new Zone();
            zone.setNom("Zone_"+i);
            zones.add(zone);
            annonce.setZones(zones);

            Add TrancheHoraires
            List<TrancheHoraire> tranchesHoraires = new ArrayList<TrancheHoraire>();
            TrancheHoraire trancheHoraire = new TrancheHoraire();
            trancheHoraire.setDebut(i);

            //Add  Annonce
            //List<Annonce> annonceList = new ArrayList<Annonce>();
            //annonceList.add(annonce);
            //trancheHoraire.setAnnonces(annonceList);
            tranchesHoraires.add(trancheHoraire);

            zones.add(zone);
            annonce.setZones(zones);
            annonce.setTranchesHoraires(tranchesHoraires);*/
            annonceDao.save(annonce);
        }

    }

    private void ajouterArrets() {
        for (int j = 0; j <= 4; j++) {
            for (int i = 1; i <= 4; i++) {
                Arret arret = new Arret();
                arret.setNom("Arret " + (j + 1) + " - " + i);
                arret.setLatitude(0);
                arret.setLongitude(0);
                arret.setZone(zoneDao.findAll().get(j));
                arretDao.save(arret);
            }
        }

    }

    private void ajouterTranchesHoraires() {
        for (int i = 6; i <=20; i++) {
            TrancheHoraire trancheHoraire = new TrancheHoraire();
            trancheHoraire.setDebut(i);
            trancheHoraireDao.save(trancheHoraire);
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
