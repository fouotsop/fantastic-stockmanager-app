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
public class Departement  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Le nom du département est obligatoire")
    @NotNull(message = "Le nom du département ne peut pas être null")
    @NotBlank(message = "Le nom du département ne peut pas être vide")
    private String nom;   

    @OneToMany(mappedBy = "departement")
    private List<FormationSanitaire> formationSanitaires;

    public Departement() {}

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
    public List<FormationSanitaire> getFormationSanitaires() {
        return formationSanitaires;
    }

    public void setFormationSanitaires(List<FormationSanitaire> formationSanitaires) {
        this.formationSanitaires = formationSanitaires;
    }



}
