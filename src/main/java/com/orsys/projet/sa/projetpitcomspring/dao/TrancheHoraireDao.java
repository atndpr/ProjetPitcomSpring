package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.TrancheHoraire;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrancheHoraireDao extends JpaRepository<TrancheHoraire,Long> {
}
