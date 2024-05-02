package com.hivcaremanager.stockmanagement.repository.utilisateur;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Utilisateur;

@Repository
public interface UtilisateurRepository {
    
    public Utilisateur add(Utilisateur utilisateur);

    public Utilisateur findByEmail(String email);

    public Utilisateur update(Utilisateur utilisateur);
}
