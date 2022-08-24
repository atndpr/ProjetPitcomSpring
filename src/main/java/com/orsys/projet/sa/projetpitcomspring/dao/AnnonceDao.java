package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceDao extends JpaRepository<Annonce, Long> {
}
