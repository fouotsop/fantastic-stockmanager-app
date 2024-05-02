package com.hivcaremanager.stockmanagement.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateLigneTraitementRequest {

    @NotEmpty(message = "Le nom de la ligne de traitement ne peut pas être vide")
    @NotNull(message = "Le nom de la ligne de traitement ne peut pas être null")
    private String nom;

    public CreateLigneTraitementRequest() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    
}
