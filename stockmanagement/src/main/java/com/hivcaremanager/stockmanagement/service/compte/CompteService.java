package com.hivcaremanager.stockmanagement.service.compte;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Compte;

@Service
public interface CompteService {
    
    public Compte add(Compte compte);
}
