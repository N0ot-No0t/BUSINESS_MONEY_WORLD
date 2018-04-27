package com.patateco.qc.ca.businessmoneyworld;

public class MatierePremiere extends Object {

    int image;
    double prix;
    String nom;

    public MatierePremiere(String nom,double prix, int image){

        this.image = image;
        this.nom = nom;
        this.prix = prix;

    }

    public int getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }
}
