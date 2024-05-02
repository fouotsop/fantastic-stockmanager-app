package com.hivcaremanager.stockmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDepartementRequest {

    @NotNull(message = "Nom cannot be null")
    @NotBlank(message = "Nom cannot be blank")
    private String nom;

    public CreateDepartementRequest() {}

    public CreateDepartementRequest(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }


}
