package com.hivcaremanager.stockmanagement.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Antiretroviral {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @NotNull(message = "Le nom de l'antiretroviral est obligatoire")
    @NotBlank(message = "Le nom de l'antiretroviral ne peut pas être vide")
    @NotEmpty(message = "Le nom de l'antiretroviral ne peut pas être vide")
    private String nom;

    @Column
    private String laboratoire;

    @OneToMany(mappedBy = "antiretroviral")
    private List<Stock> stocks;

    @ManyToOne(fetch = FetchType.LAZY)
    private LigneTraitement ligneTraitement;

    public Antiretroviral() {
    }

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

    public String getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(String laboratoire) {
        this.laboratoire = laboratoire;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public LigneTraitement getLigneTraitement() {
        return ligneTraitement;
    }

    public void setLigneTraitement(LigneTraitement ligneTraitement) {
        this.ligneTraitement = ligneTraitement;
    }
    

}
