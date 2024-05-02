package com.hivcaremanager.stockmanagement.repository.compte;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.Compte;
import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
import com.hivcaremanager.stockmanagement.model.Role;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CompteRepositoryImpl implements CompteRepository{

    private final CompteJpaRepository compteJpaRepository;
    private final EntityManager entityManager;  

    public CompteRepositoryImpl(EntityManager entityManager, CompteJpaRepository compteJpaRepository) {

        this.entityManager = entityManager;
        this.compteJpaRepository = compteJpaRepository;
    }

    @Override
    @Transactional
    public Compte add(Compte compte) {

        if (this.compteJpaRepository.existsByLogin(compte.getLogin())) throw new EntityNotFoundException("Login already exists");
        
        
        FormationSanitaire formationSanitaire = entityManager.find(FormationSanitaire.class, compte.getUtilisateur().getFormationSanitaire().getId());
        if (formationSanitaire == null) throw new EntityNotFoundException("FormationSanitaire with id " + compte.getUtilisateur().getFormationSanitaire().getClass() + " not found");

        compte.getUtilisateur().setFormationSanitaire(formationSanitaire);
        Role role = entityManager.find(Role.class, compte.getRole().getId());

        compte.setRole(role);

        compte = entityManager.merge(compte);
        return null;
    }

    @Override
    public boolean existsByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByLogin'");
    }
    
}
