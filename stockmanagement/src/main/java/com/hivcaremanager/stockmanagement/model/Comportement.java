package com.hivcaremanager.stockmanagement.model;


import java.util.UUID;

public class Comportement {
    private UUID id;

    private String exipiringProbability;

    private String excessProbability;

    private String surplus;

    private String date;

    
    public Comportement() {
        super();
    }

    public Comportement(UUID id, String exipiringProbability, String excessProbability, String surplus, String date) {
        this.id = id;
        this.exipiringProbability = exipiringProbability;
        this.excessProbability = excessProbability;
        this.surplus = surplus;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getExipiringProbability() {
        return exipiringProbability;
    }

    public void setExipiringProbability(String exipiringProbability) {
        this.exipiringProbability = exipiringProbability;
    }

    public String getExcessProbability() {
        return excessProbability;
    }

    public void setExcessProbability(String excessProbability) {
        this.excessProbability = excessProbability;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    



}
