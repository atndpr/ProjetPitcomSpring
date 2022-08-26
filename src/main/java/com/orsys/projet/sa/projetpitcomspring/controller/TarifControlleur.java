package com.orsys.projet.sa.projetpitcomspring.controller;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Tarif;
import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;
import com.orsys.projet.sa.projetpitcomspring.business.Zone;
import com.orsys.projet.sa.projetpitcomspring.dto.TarifDto;
import com.orsys.projet.sa.projetpitcomspring.service.TarifService;
import com.orsys.projet.sa.projetpitcomspring.service.TrancheHoraireService;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import com.orsys.projet.sa.projetpitcomspring.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/")
public class TarifControlleur {
    private final TarifService tarifService;
    private final UtilisateurService utilisateurService;
    private final TrancheHoraireService trancheHoraireService;
    private final ZoneService zoneService;

    @GetMapping(value = "tarif")
    List<Tarif> getAllTarifs() {
        return tarifService.findAllTarifs();
    }

    @PostMapping(value = "tarif/{administrateurId}")
    @ResponseStatus(HttpStatus.CREATED)
    Tarif addTarif(@PathVariable Long administrateurId, @RequestBody TarifDto tarifDto) {
        Optional<Administrateur> adminOpt = utilisateurService.findAdminById(administrateurId);

        if (adminOpt.isPresent()) {
            Tarif tarif = new Tarif();

            tarif.setAdministrateur(adminOpt.get());

            tarif.setPrixEnEuros(tarifDto.getPrixEnEuros());

            Optional<TrancheHoraire> trancheHoraireOpt = trancheHoraireService.findTrancheHoraireById(tarifDto.getTrancheHoraireId());

            if (trancheHoraireOpt.isPresent()) {
                TrancheHoraire trancheHoraire = trancheHoraireOpt.get();
                tarif.setTrancheHoraire(trancheHoraire);
            }

            Optional<Zone> zoneOpt = zoneService.findZoneById(tarifDto.getZoneId());

            if (zoneOpt.isPresent()) {
                Zone zone = zoneOpt.get();
                tarif.setZone(zone);
            }

            return tarifService.addTarif(tarif);
        }
        return null;
    }
}
