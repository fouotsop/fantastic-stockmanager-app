package com.hivcaremanager.stockmanagement.repository.antiretroviral;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.Antiretroviral;
import com.hivcaremanager.stockmanagement.model.LigneTraitement;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AntiretroviralRepositoryImpl implements AntiretroviralRepository {

    private final AntiretroviralJpaRepository antiretroviralJpaRepository;
    private final EntityManager entityManager;

    
    public AntiretroviralRepositoryImpl(EntityManager entityManager, AntiretroviralJpaRepository antiretroviralJpaRepository) {
        this.entityManager = entityManager;
        this.antiretroviralJpaRepository = antiretroviralJpaRepository;
    }


    @Override
    @Transactional
    public Antiretroviral create(Antiretroviral antiretroviral) {
        
        UUID ligneTraitementId = antiretroviral.getLigneTraitement().getId();
        LigneTraitement ligneTraitement = entityManager.find(LigneTraitement.class, ligneTraitementId);
        if (ligneTraitement == null) throw new EntityNotFoundException("LigneTraitement with id " + ligneTraitementId + " not found");

        boolean existence = antiretroviralJpaRepository.existsByNomAndLigneTraitementId(antiretroviral.getNom(), ligneTraitementId);
        if (existence == true) throw new EntityNotFoundException("Antiretroviral with name " + antiretroviral.getNom() + " already exists for this LigneTraitement");

        antiretroviral.setLigneTraitement(ligneTraitement);
        antiretroviral = entityManager.merge(antiretroviral);

        return antiretroviral;
    }


    @Override
    public Antiretroviral update(Antiretroviral antiretroviral) {

        LigneTraitement ligneTraitement = entityManager.find(LigneTraitement.class, antiretroviral.getLigneTraitement().getId());   
        if (ligneTraitement == null) throw new EntityNotFoundException("LigneTraitement with id " + antiretroviral.getLigneTraitement().getId() + " not found");    

        antiretroviral.setLigneTraitement(ligneTraitement);

        antiretroviral = antiretroviralJpaRepository.save(antiretroviral);

        return antiretroviral;

    }


    @Override
    public Antiretroviral findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    @Override
    public List<Antiretroviral> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    @Override
    public List<Antiretroviral> findByDepartementId(UUID id) {
        return this.antiretroviralJpaRepository.findByLigneTraitementId(id);
    }


    @Override
    @Transactional
    public Antiretroviral updateLigneTraitement(UUID ligneTraitementActuel, UUID ligneTraitementNouveau, UUID antiretroviralId) {

        final String jpql = "UPDATE Antiretroviral a SET a.ligneTraitement.id = :ligneTraitementNouveau WHERE a.ligneTraitement.id = :ligneTraitementActuel AND a.id = :antiretroviralId";

        final int rows = entityManager.createNamedQuery(jpql)
            .setParameter("ligneTraitementNouveau", ligneTraitementNouveau)
            .setParameter("ligneTraitementActuel", ligneTraitementActuel)
            .setParameter("antiretroviralId", antiretroviralId)
            .executeUpdate();
        
        if (rows > 0) return entityManager.find(Antiretroviral.class, antiretroviralId);

        throw new EntityNotFoundException("No Antiretroviral with id " + antiretroviralId + " found for LigneTraitement with id " + ligneTraitementActuel);
    }   
   
    
}
