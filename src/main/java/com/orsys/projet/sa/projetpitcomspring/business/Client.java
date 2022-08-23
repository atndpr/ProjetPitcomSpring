package com.orsys.projet.sa.projetpitcomspring.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Client extends Utilisateur {
    private String numeroDeTelephone;
    @ManyToOne
    private Annonce annonces;
}
