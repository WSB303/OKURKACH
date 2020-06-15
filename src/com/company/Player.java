package com.company;


public class Player {

    public String name;
    public Farms[] farm;
    public Player(String name, int maxRozmiar) {
        this.name = name;
        this.farm = new Farms[maxRozmiar];
    }

    public String getName() {
        return name;
    }
    public void setFarm(Farms farm,Integer index) {
        this.farm[index] = farm;
    }

    public String toString() {
        return name + " " + farm;
    }

}
