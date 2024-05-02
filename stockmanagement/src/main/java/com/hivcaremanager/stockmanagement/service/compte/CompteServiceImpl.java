package com.hivcaremanager.stockmanagement.service.compte;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Compte;
import com.hivcaremanager.stockmanagement.repository.compte.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService{

    private final CompteRepository compteRepository;

    public CompteServiceImpl (CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
    @Override
    public Compte add(Compte compte) {
        return this.compteRepository.add(compte);
    }

    
}
