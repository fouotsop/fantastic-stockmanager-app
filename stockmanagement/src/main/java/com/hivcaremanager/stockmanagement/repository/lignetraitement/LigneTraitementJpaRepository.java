package com.hivcaremanager.stockmanagement.repository.lignetraitement;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.LigneTraitement;

public interface LigneTraitementJpaRepository extends JpaRepository<LigneTraitement, UUID> {

    public boolean existsByNom(String nom);
    
}
