package com.hivcaremanager.stockmanagement.repository.lignetraitement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.LigneTraitement;

@Repository
public class LigneTraitementRepositoryImpl implements LigneTraitementRepository {
    
    private final LigneTraitementJpaRepository ligneTraitementJpaRepository;

    public LigneTraitementRepositoryImpl(LigneTraitementJpaRepository ligneTraitementJpaRepository) {
        this.ligneTraitementJpaRepository = ligneTraitementJpaRepository;
    }

    @Override
    public LigneTraitement add(LigneTraitement ligneTraitement) {

        boolean existsByNom = ligneTraitementJpaRepository.existsByNom(ligneTraitement.getNom());

        if (!existsByNom) return ligneTraitementJpaRepository.save(ligneTraitement);
        
        throw new EntityNotFoundException("LigneTraitement with name '" + ligneTraitement.getNom() + "' already exists");
    }

    @Override
    public LigneTraitement update(LigneTraitement ligneTraitement) {
        return this.ligneTraitementJpaRepository.save(ligneTraitement);
    }

    @Override
    public LigneTraitement findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<LigneTraitement> findAll() {
        return this.ligneTraitementJpaRepository.findAll();
    }
    
}
