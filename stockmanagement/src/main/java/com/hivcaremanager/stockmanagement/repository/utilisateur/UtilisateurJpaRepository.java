package com.hivcaremanager.stockmanagement.repository.utilisateur;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.Utilisateur;

public interface UtilisateurJpaRepository extends JpaRepository<Utilisateur, UUID>{
    
    public boolean existsByEmail (String email);
}
