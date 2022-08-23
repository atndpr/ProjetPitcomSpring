package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Arret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArretDao extends JpaRepository<Arret, Long> {
}
