package com.hivcaremanager.stockmanagement.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotNull(message = "La quantité initiale est obligatoire")
    @NotEmpty(message = "La quantité initiale ne peut pas être vide")
    private Long quantiteInitial;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dateReaprovisionement;

    @Column(nullable = false)
    @NotNull(message = "La date de peremption est obligatoire")
    private LocalDateTime datePeremption;

    @Column
    private String numeroLot;

    @Column
    private String dosage;

    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    private Antiretroviral antiretroviral;

    public Stock () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getQuantiteInitial() {
        return quantiteInitial;
    }

    public void setQuantiteInitial(Long quantiteInitial) {
        this.quantiteInitial = quantiteInitial;
    }

    public LocalDateTime getDateReaprovisionement() {
        return dateReaprovisionement;
    }

    public void setDateReaprovisionement(LocalDateTime dateReaprovisionement) {
        this.dateReaprovisionement = dateReaprovisionement;
    }

    public LocalDateTime getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDateTime datePeremption) {
        this.datePeremption = datePeremption;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @JsonIgnore
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @JsonIgnore
    public Antiretroviral getAntiretroviral() {
        return antiretroviral;
    }

    public void setAntiretroviral(Antiretroviral antiretroviral) {
        this.antiretroviral = antiretroviral;
    }

    

}
