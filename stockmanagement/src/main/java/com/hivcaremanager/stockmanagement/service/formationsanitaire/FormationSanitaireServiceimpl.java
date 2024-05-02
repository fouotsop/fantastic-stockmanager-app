package com.hivcaremanager.stockmanagement.service.formationsanitaire;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
import com.hivcaremanager.stockmanagement.repository.fomationsanitaire.FormationSanitaireRepository;

@Service
public class FormationSanitaireServiceimpl implements FormationSanitaireService{
    
    private final FormationSanitaireRepository formationSanitaireRepository;

    public FormationSanitaireServiceimpl(FormationSanitaireRepository formationSanitaireRepository) {
        this.formationSanitaireRepository = formationSanitaireRepository;
    }

    @Override
    public FormationSanitaire save(FormationSanitaire formationSanitaire) {
        return formationSanitaireRepository.save(formationSanitaire);
    }

    @Override
    public FormationSanitaire update(FormationSanitaire formationSanitaire) {
        return formationSanitaireRepository.update(formationSanitaire);
    }

    @Override
    public List<FormationSanitaire> findByDepartementId(UUID id) {
        return formationSanitaireRepository.findByDepartementId(id);
    }

    
    
}
