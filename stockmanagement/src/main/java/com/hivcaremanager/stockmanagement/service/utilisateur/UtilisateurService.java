package com.hivcaremanager.stockmanagement.service.utilisateur;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Utilisateur;

@Service
public interface UtilisateurService {
    
    public Utilisateur add(Utilisateur utilisateur);

    public Utilisateur findByEmail(String email);

    public Utilisateur update(Utilisateur utilisateur);

    public boolean existsByEmail(String email);
}
