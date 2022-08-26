package com.orsys.projet.sa.projetpitcomspring.controller;

import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.service.AnnonceService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/")
public class AnnonceControlleur {

    private final AnnonceService annonceService;

    @GetMapping("annonces")//feature 3
    public List<Annonce> getAnnonces(){
        return annonceService.recupererAnnonces();
    }

    //feature 4


    @GetMapping("annonce/{clientId}")//feature 5
    public List<Annonce> getAnnoncesClient(@PathVariable String clientId){
        return annonceService.recupererAnnoncesClient(clientId);
    }

}
