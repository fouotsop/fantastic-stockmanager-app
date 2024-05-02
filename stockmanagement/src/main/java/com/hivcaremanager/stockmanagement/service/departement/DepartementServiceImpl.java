package com.hivcaremanager.stockmanagement.service.departement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Departement;
import com.hivcaremanager.stockmanagement.repository.departement.DepartementRepository;

@Service
public class DepartementServiceImpl implements DepartementService {


    private final DepartementRepository departementRepository;
    
    public DepartementServiceImpl(DepartementRepository departementRepository) {

        this.departementRepository = departementRepository;

    }


    @Override
    public Departement save(Departement departement) {
        return departementRepository.save(departement);

    }


    @Override
    public List<Departement> findAll() {
        return this.departementRepository.findAll();
    }

    
}
