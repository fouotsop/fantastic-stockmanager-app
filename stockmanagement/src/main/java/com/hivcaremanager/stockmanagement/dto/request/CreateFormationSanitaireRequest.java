package com.hivcaremanager.stockmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateFormationSanitaireRequest {

    @NotNull(message = "Le nom de la formation sanitaire ne doit pas être null")
    @NotBlank(message = "Le nom de la formation sanitaire ne doit pas être vide")
    private String nom;

    public CreateFormationSanitaireRequest() {
    }

    public CreateFormationSanitaireRequest(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CreateFormationSanitaireRequest nom(String nom) {
        this.nom = nom;
        return this;
    }

}
