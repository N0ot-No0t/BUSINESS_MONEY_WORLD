package com.patateco.qc.ca.businessmoneyworld;

/**
 * Created by Noot on 27/02/2018.
 */

public class Personnage {
    String name;
    int age;
    double creditScore;
    double currentCash;


    public Personnage(String name,int age, double creditScore,double currentCash){
        this.name = name;
        this.age = age;
        this.creditScore = creditScore;
        this.currentCash = currentCash;


    }

    public double getCash(){
        return currentCash;
    }

}
