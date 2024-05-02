package com.hivcaremanager.stockmanagement.repository.lignetraitement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.LigneTraitement;

@Repository
public interface LigneTraitementRepository {

    public LigneTraitement add (LigneTraitement ligneTraitement);
    
    public LigneTraitement update (LigneTraitement ligneTraitement);

    public LigneTraitement findById (UUID id);

    public List<LigneTraitement> findAll();
}

