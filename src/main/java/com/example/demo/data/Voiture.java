package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voiture {
    int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String marque;

    private double prix;

    public Voiture() {}

    public Voiture(String marque, double prix) {
        this.marque = marque;
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
