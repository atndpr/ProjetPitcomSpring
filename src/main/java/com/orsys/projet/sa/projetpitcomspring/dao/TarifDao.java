package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Tarif;
import com.orsys.projet.sa.projetpitcomspring.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifDao extends JpaRepository<Tarif,Long> {
}
