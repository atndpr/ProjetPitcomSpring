package com.orsys.projet.sa.projetpitcomspring.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @ManyToMany (mappedBy = "trancheHoraires", cascade = CascadeType.REMOVE)
    private List<Annonce> annonces;
}
