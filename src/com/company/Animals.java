package com.company;

public class Animals {
    public String species;
    public String name;
    public Double weight;
public Animals(String species,String name, Double weight){
    this.species = species;
    this.name = name;
    this.weight = weight;
}
    public void feed(){
        if (weight > 0){
            System.out.println("Nakarmiłeś swoje zwierze.");
            weight++;
        }
    }
}
