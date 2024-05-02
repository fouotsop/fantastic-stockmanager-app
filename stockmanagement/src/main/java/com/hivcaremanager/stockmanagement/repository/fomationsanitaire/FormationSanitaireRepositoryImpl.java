package com.hivcaremanager.stockmanagement.repository.fomationsanitaire;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.Departement;
import com.hivcaremanager.stockmanagement.model.FormationSanitaire;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class FormationSanitaireRepositoryImpl implements FormationSanitaireRepository {

    private final EntityManager entityManager;
    private final FormationSanitaireJpaRepository formationSanitaireJpaRepository;

    public FormationSanitaireRepositoryImpl(EntityManager entityManager, FormationSanitaireJpaRepository formationSanitaireJpaRepository) {

        this.entityManager = entityManager;
        this.formationSanitaireJpaRepository = formationSanitaireJpaRepository;
    }


    @Override
    @Transactional
    public FormationSanitaire save(FormationSanitaire formationSanitaire) {

        Departement departement = entityManager.find(Departement.class, formationSanitaire.getDepartement().getId());
        if (departement  == null) throw new EntityNotFoundException("Departement with id " + formationSanitaire.getDepartement().getId() + " not found");

        formationSanitaire.setDepartement(departement);
        formationSanitaire = entityManager.merge(formationSanitaire);

        return formationSanitaire;
    }

    @Override
    @Transactional
    public FormationSanitaire update(FormationSanitaire formationSanitaire) {

        String jpql = "UPDATE FormationSanitaire fs SET fs.nom = :nom, fs.departement.id = :departementId WHERE fs.id = :id";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", formationSanitaire.getId());
        query.setParameter("nom", formationSanitaire.getNom());
        query.setParameter("departementId", formationSanitaire.getDepartement().getId());

        int updatedCount = query.executeUpdate();

        if (updatedCount == 0) {
            throw new EntityNotFoundException("FormationSanitaire with id " + formationSanitaire.getId() + " not found");
        }
        return entityManager.find(FormationSanitaire.class,formationSanitaire.getId());
    }

    @Override
    public FormationSanitaire findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<FormationSanitaire> findAll() {
        return null;
    }


    @Override
    public List<FormationSanitaire> findByDepartementId(UUID id) {
        return this.formationSanitaireJpaRepository.findByDepartementId(id);
    }
    
}
