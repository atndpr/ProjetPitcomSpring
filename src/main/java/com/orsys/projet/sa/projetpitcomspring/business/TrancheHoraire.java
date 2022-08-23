package com.orsys.projet.sa.projetpitcomspring.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TrancheHoraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int debut;
    @ManyToMany(mappedBy = "trancheHoraires", cascade = CascadeType.REMOVE)
    private List<Annonce> annonces;
}
