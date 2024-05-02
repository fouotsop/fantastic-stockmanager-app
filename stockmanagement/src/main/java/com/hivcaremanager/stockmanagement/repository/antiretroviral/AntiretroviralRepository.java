package com.hivcaremanager.stockmanagement.repository.antiretroviral;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Antiretroviral;

@Repository
public interface AntiretroviralRepository {
   
    public Antiretroviral create(Antiretroviral antiretroviral);

    public Antiretroviral update(Antiretroviral antiretroviral);

    public Antiretroviral findById(UUID id);

    public List<Antiretroviral> findAll();

    public List<Antiretroviral> findByDepartementId(UUID id);

    public Antiretroviral updateLigneTraitement(UUID ligneTraitementActuel, UUID ligneTraitementNouveau,
            UUID antiretroviralId);
}
