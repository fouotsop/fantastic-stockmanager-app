package com.hivcaremanager.stockmanagement.service.lignetraitement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.LigneTraitement;
import com.hivcaremanager.stockmanagement.repository.lignetraitement.LigneTraitementRepository;

@Service
public class LigneTraitementServiceImpl implements LigneTraitementService{
    
    private final LigneTraitementRepository ligneTraitementRepository;

    public LigneTraitementServiceImpl(LigneTraitementRepository ligneTraitementRepository) {
        this.ligneTraitementRepository = ligneTraitementRepository;
    }

    @Override
    public LigneTraitement add(LigneTraitement ligneTraitement) {
        return ligneTraitementRepository.add(ligneTraitement);
    }

    @Override
    public LigneTraitement update(LigneTraitement ligneTraitement) {
        return this.ligneTraitementRepository.update(ligneTraitement);
    }

    @Override
    public List<LigneTraitement> findAll() {
        return this.ligneTraitementRepository.findAll();
    }
}
