package com.hivcaremanager.stockmanagement.service.departement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Departement;

@Service
public interface DepartementService {
    
    Departement save (Departement department);

    List<Departement> findAll();
    
}
