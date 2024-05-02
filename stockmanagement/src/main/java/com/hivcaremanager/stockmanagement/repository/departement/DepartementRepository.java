package com.hivcaremanager.stockmanagement.repository.departement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Departement;

@Repository
public interface DepartementRepository {
    
    public Departement save(Departement departement);

    public Departement update(Departement departement);

    public Departement findById(UUID id);

    public List<Departement> findAll();
}
