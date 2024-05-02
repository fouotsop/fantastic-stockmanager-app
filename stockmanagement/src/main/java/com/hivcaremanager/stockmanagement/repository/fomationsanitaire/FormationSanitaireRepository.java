package com.hivcaremanager.stockmanagement.repository.fomationsanitaire;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.FormationSanitaire;

@Repository
public interface FormationSanitaireRepository {

    public FormationSanitaire save (FormationSanitaire formationSanitaire); 
    
    public FormationSanitaire update (FormationSanitaire formationSanitaire);

    public FormationSanitaire findById (Long id);

    public List<FormationSanitaire> findByDepartementId(UUID id);

    public List<FormationSanitaire> findAll();

    
} 