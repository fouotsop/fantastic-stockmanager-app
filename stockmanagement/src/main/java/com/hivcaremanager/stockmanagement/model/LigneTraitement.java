package com.hivcaremanager.stockmanagement.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class LigneTraitement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Le nom de la ligne de traitement ne peut pas être vide")
    @NotNull(message = "Le nom de la ligne de traitement ne peut pas être null")
    private String nom;

    @OneToMany(mappedBy = "ligneTraitement")
    private List<Antiretroviral> antiretrovirals;

    public LigneTraitement() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonIgnore
    public List<Antiretroviral> getAntiretrovirals() {
        return antiretrovirals;
    }

    public void setAntiretrovirals(List<Antiretroviral> antiretrovirals) {
        this.antiretrovirals = antiretrovirals;
    }

    


}
