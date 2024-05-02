package com.hivcaremanager.stockmanagement.repository.compte;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Compte;

@Repository
public interface CompteRepository {

    public Compte add(Compte compte);

    public boolean existsByLogin(String login);
    
}
