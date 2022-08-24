package com.orsys.projet.sa.projetpitcomspring.controller;


import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.UtilisateurDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UtilisateurControlleur {

    private UtilisateurService utilisateurService;

    @PostMapping("/inscription") //feature 1
    public ResponseEntity<Utilisateur> inscription() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom();
        return ResponseEntity.ok(utilisateur);null;
    }
    @GetMapping("/auth") //feature 2
    public ResponseEntity<Utilisateur> auth() {

        return null;
    }

}
