package com.hivcaremanager.stockmanagement.repository.departement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;
import com.hivcaremanager.stockmanagement.model.Departement;


@Repository
public class DepartementRepositoryImpl implements DepartementRepository{

    private final DepartementJpaRepository departementJpaRepository;
    
    public DepartementRepositoryImpl(DepartementJpaRepository departementJpaRepository) {
        this.departementJpaRepository = departementJpaRepository;
    }

    @Override
    public Departement save(Departement departement) {
        boolean exists = departementJpaRepository.existsByNom(departement.getNom());
        if (!exists) return departementJpaRepository.save(departement);

        throw new EntityNotFoundException("Departement with name " + departement.getNom() + " already exists");
        
    }


    @Override
    public Departement update(Departement departement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Departement findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Departement> findAll() {
        return departementJpaRepository.findAll();
    }
    
}
