package com.hivcaremanager.stockmanagement.repository.compte;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.Compte;

public interface CompteJpaRepository extends JpaRepository<Compte, UUID>{
    
    boolean existsByLogin(String login);

}
