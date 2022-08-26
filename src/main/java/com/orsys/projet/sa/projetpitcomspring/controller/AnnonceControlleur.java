package com.orsys.projet.sa.projetpitcomspring.controller;

import com.orsys.projet.sa.projetpitcomspring.business.*;
import com.orsys.projet.sa.projetpitcomspring.dto.AnnonceDto;
import com.orsys.projet.sa.projetpitcomspring.service.AnnonceService;
import com.orsys.projet.sa.projetpitcomspring.service.TrancheHoraireService;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import com.orsys.projet.sa.projetpitcomspring.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/")
public class AnnonceControlleur {
    private final AnnonceService annonceService;
    private final UtilisateurService utilisateurService;
    private final ZoneService zoneService;
    private final TrancheHoraireService trancheHoraireService;

    @GetMapping("annonces")//feature 3
    public List<Annonce> getAnnonces(){
        return annonceService.recupererAnnonces();
    }

    @PostMapping(value = "annonce/{clientId}")//feature 4
    @ResponseStatus(HttpStatus.CREATED)
    Annonce annonce(@PathVariable Long clientId, @RequestBody AnnonceDto annonceDto) {
        Optional<Client> clientOpt = utilisateurService.findClientById(clientId);

        if (clientOpt.isPresent()) {
            Annonce annonce = new Annonce();

            annonce.setClient(clientOpt.get());

            annonce.setDateHeureCreation(LocalDateTime.now());
            annonce.setContenu(annonceDto.getContenu());
            annonce.setDateHeureDebut(annonceDto.getDateHeureDebut());
            annonce.setDateHeureFin(annonceDto.getDateHeureFin());
            annonce.setNumeroCarte(annonceDto.getNumeroCarte());
            annonce.setMoisExpiration(annonceDto.getMoisExpiration());
            annonce.setAnneExpiration(annonceDto.getAnneExpiration());
            annonce.setCryptogramme(annonceDto.getCryptogramme());
            annonce.setMontantRegleEnEuros(annonceDto.getMontantRegleEnEuros());

            List<Zone> zones = new ArrayList<>();

            for (int i = 0; i < annonceDto.getIdZones().size(); i++) {
                Optional<Zone> zoneOpt = zoneService.findZoneById(annonceDto.getIdZones().get(i));
                if (zoneOpt.isPresent()) {
                    Zone zone = zoneOpt.get();
                    zones.add(zone);
                }
            }

            annonce.setZones(zones);

            List<TrancheHoraire> tranchesHoraires = new ArrayList<>();

            for (int i = 0; i < annonceDto.getIdTranchesHoraires().size(); i++) {
                Optional<TrancheHoraire> trancheHoraireOpt = trancheHoraireService.findTrancheHoraireById(annonceDto.getIdTranchesHoraires().get(i));
                if (trancheHoraireOpt.isPresent()) {
                    TrancheHoraire trancheHoraire = trancheHoraireOpt.get();
                    tranchesHoraires.add(trancheHoraire);
                }
            }

            annonce.setTranchesHoraires(tranchesHoraires);

            return annonceService.addAnnonce(annonce);
        }
        return null;
    }

    @GetMapping("annonce/{clientId}")//feature 5
    public List<Annonce> getAnnoncesClient(@PathVariable String clientId){
        return annonceService.recupererAnnoncesClient(clientId);
    }
}
