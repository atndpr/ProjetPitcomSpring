package com.orsys.projet.sa.projetpitcomspring.service.impl;
import com.orsys.projet.sa.projetpitcomspring.dao.ArretDao;
import com.orsys.projet.sa.projetpitcomspring.service.ArretService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ArretServiceImpl implements ArretService {
    private ArretDao arretDao;
}
