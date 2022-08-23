package com.orsys.projet.sa.projetpitcomspring.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Client extends Utilisateur {
    private String numeroDeTelephone;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Annonce> annonces;
}
