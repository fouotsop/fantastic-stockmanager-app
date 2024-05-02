package com.hivcaremanager.stockmanagement.service.formationsanitaire;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.FormationSanitaire;

@Service
public interface FormationSanitaireService {
    

    public FormationSanitaire save (FormationSanitaire formationSanitaire);

    public FormationSanitaire update (FormationSanitaire formationSanitaire);  
    
    public List<FormationSanitaire> findByDepartementId(UUID id);
}
