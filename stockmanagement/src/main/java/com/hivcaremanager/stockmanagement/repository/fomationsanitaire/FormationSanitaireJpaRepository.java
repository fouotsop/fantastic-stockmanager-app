package com.hivcaremanager.stockmanagement.repository.fomationsanitaire;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
public interface FormationSanitaireJpaRepository extends JpaRepository<FormationSanitaire, UUID> {

    List<FormationSanitaire> findByDepartementId(UUID id);
    
}  