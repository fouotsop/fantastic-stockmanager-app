package com.hivcaremanager.stockmanagement.service.lignetraitement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.LigneTraitement;

@Service
public interface LigneTraitementService {
    
    public LigneTraitement add (LigneTraitement ligneTraitement);

    public LigneTraitement update (LigneTraitement ligneTraitement);

    public List<LigneTraitement> findAll();
}
