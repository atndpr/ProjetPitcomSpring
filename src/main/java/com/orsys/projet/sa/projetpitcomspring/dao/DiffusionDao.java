package com.orsys.projet.sa.projetpitcomspring.dao;

import com.orsys.projet.sa.projetpitcomspring.business.Diffusion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiffusionDao extends JpaRepository<Diffusion, Long> {
}
