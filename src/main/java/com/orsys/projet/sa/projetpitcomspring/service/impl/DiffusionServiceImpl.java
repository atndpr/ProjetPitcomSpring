package com.orsys.projet.sa.projetpitcomspring.service.impl;

import com.orsys.projet.sa.projetpitcomspring.dao.DiffusionDao;
import com.orsys.projet.sa.projetpitcomspring.service.DiffusionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiffusionServiceImpl implements DiffusionService {
    private DiffusionDao diffusionDao;
}
