package com.hivcaremanager.stockmanagement.service.antiretroviral;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Antiretroviral;

@Service
public interface AntiretroviralService {

    public Antiretroviral add(Antiretroviral antiretroviral);

    public Antiretroviral update(Antiretroviral antiretroviral);

    public Antiretroviral findById(UUID id);

    public Antiretroviral findAll();

    public Antiretroviral updateLigneTraitement(UUID ligneTraitementActuel, UUID ligneTraitementNouveau, UUID antiretroviralId);
}
