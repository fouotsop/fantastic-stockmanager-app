package com.hivcaremanager.stockmanagement.repository.utilisateur;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
import com.hivcaremanager.stockmanagement.model.Utilisateur;

import jakarta.persistence.EntityManager;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository{

    private UtilisateurJpaRepository utilisateurJpaRepository;
    private final EntityManager entityManager;
    public UtilisateurRepositoryImpl(EntityManager entityManager, UtilisateurJpaRepository utilisateurJpaRepository) {
        this.entityManager = entityManager;
        this.utilisateurJpaRepository = utilisateurJpaRepository;
    }

    @Override
    public Utilisateur add(Utilisateur utilisateur) {
        FormationSanitaire formationSanitaire = entityManager.find(FormationSanitaire.class, utilisateur.getFormationSanitaire().getId());
        if (formationSanitaire == null) throw new EntityNotFoundException("FormationSanitaire with id " + utilisateur.getFormationSanitaire().getId() + " not found");

        boolean exists = utilisateurJpaRepository.existsByEmail(utilisateur.getEmail());
        if (exists) throw new EntityNotFoundException("Email " + utilisateur.getEmail() + " already exists");

        utilisateur.setFormationSanitaire(formationSanitaire);
        utilisateur = entityManager.merge(utilisateur);

        return utilisateur;
    }

    @Override
    public Utilisateur findByEmail(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
