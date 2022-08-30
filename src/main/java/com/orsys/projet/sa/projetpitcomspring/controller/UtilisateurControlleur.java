package com.orsys.projet.sa.projetpitcomspring.controller;


import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import com.orsys.projet.sa.projetpitcomspring.business.Client;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import com.orsys.projet.sa.projetpitcomspring.dao.AdministrateurDao;
import com.orsys.projet.sa.projetpitcomspring.dao.ClientDao;
import com.orsys.projet.sa.projetpitcomspring.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UtilisateurControlleur {

    @Resource
    private UtilisateurService utilisateurService;
    @Resource
    private AdministrateurDao administrateurDao;
    @Resource
    private ClientDao clientDao;

    @GetMapping("/utilsateurs")
    public List<Utilisateur> getAnnonces(){
        return utilisateurService.recupererUtilisateurs();
    }

    @PostMapping("/inscription") //feature 1
    public Client inscriptUtilisateur(@RequestBody Client client){
        return utilisateurService.inscriptService(client);
    }

    @PostMapping("/authentication") //feature 2
    public String loginService(@RequestParam String email, @RequestParam String motDePassse) {
        Client client = clientDao.findByEmailAndMotDePassse(email, motDePassse);
        Administrateur  admin = administrateurDao.findByEmailAndMotDePassse(email, motDePassse);
        if(client != null && client.getNumeroDeTelephone() != null){
            return "redirect:/api/client/annonces";
            //"login success as client"
        }else if(admin != null){
            return "redirect:/api/admin/annonces";
            //"login success as admin";
        }
        return "login failed";
    }

}
