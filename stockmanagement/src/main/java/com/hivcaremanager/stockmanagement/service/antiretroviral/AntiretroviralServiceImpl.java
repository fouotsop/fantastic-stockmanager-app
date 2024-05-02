package com.hivcaremanager.stockmanagement.service.antiretroviral;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.hivcaremanager.stockmanagement.model.Antiretroviral;
import com.hivcaremanager.stockmanagement.repository.antiretroviral.AntiretroviralRepository;

@Component
public class AntiretroviralServiceImpl implements AntiretroviralService {

    private final AntiretroviralRepository antiretroviralRepository;

    public AntiretroviralServiceImpl(AntiretroviralRepository antiretroviralRepository) {
        this.antiretroviralRepository = antiretroviralRepository;
    }


    @Override
    public Antiretroviral add(Antiretroviral antiretroviral) {
        return antiretroviralRepository.create(antiretroviral);
    }

    @Override
    public Antiretroviral update(Antiretroviral antiretroviral) {
        return antiretroviralRepository.update(antiretroviral);
    }

    @Override
    public Antiretroviral findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Antiretroviral findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    @Override
    public Antiretroviral updateLigneTraitement(UUID ligneTraitementActuel, UUID ligneTraitementNouveau,
            UUID antiretroviralId) {
            
            return this.antiretroviralRepository.updateLigneTraitement(ligneTraitementActuel, ligneTraitementNouveau, antiretroviralId);
    }
    
}
