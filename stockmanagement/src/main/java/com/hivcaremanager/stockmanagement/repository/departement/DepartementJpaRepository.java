package com.hivcaremanager.stockmanagement.repository.departement;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.Departement;

public interface DepartementJpaRepository extends JpaRepository <Departement, UUID>{
    
    boolean existsByNom(String nom);
}
