package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurDao extends JpaRepository<Administrateur, Long> {
}
