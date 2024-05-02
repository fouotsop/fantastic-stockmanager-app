package com.hivcaremanager.stockmanagement.dto.request;

public class CreateAntiretroviralRequest {

    private String nom;

    private String laboratoire;


    public CreateAntiretroviralRequest() {}


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

    
}
