package com.hivcaremanager.stockmanagement.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String fonction;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    private Compte compte;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private FormationSanitaire formationSanitaire;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Stock> stock;


    public Utilisateur () {
        super();
    }
    

    public Utilisateur(UUID id, String nom, String email, String fonction) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.fonction = fonction;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @JsonIgnore
    public Compte getCompte() {
        return compte;
    }


    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @JsonIgnore
    public FormationSanitaire getFormationSanitaire() {
        return formationSanitaire;
    }


    public void setFormationSanitaire(FormationSanitaire formationSanitaire) {
        this.formationSanitaire = formationSanitaire;
    }

    @JsonIgnore
    public List<Stock> getStock() {
        return stock;
    }


    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }


}
