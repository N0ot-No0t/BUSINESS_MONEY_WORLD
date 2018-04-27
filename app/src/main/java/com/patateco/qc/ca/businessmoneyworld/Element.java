package com.patateco.qc.ca.businessmoneyworld;

public class Element extends Object {

    int image;
    double qtt;
    String nom;

    public Element(String nom,double qtt, int image){

        this.image = image;
        this.nom = nom;
        this.qtt = qtt;

    }

    public int getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public double getQtt() {
        return qtt;
    }
}
