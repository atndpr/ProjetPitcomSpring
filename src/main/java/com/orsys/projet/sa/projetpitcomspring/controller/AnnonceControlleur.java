package com.orsys.projet.sa.projetpitcomspring.controller;

import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.service.AnnonceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AnnonceControlleur {

    private final AnnonceService annonceService;

    @GetMapping("annonces")//feature 3
    public ResponseEntity<List<Annonce>> getAnnonces(){
        return ResponseEntity.ok().body(annonceService.recupererAnnonces());
    }

    //feature 4

    /*//feature 5
    @GetMapping("annonces/{id}")
    public ResponseEntity<List<Annonce>> getAnnoncesClient(String id){}*/

}
