package com.company.jednostki;

public class Budynek {
    public String Nazwa;
    public int Cena;
    public int Zwierzeta;

    public Budynek(int Cena, String Nazwa, int Zwierzeta){
        this.Cena = Cena;
        this.Nazwa = Nazwa;
        this.Zwierzeta = Zwierzeta;
    }
    public String Wypisz()
    {
        return "Nazwa: "+Nazwa+" Cena: "+Cena+" Miejsce na zwirzeta: "+Zwierzeta;
    }
}
