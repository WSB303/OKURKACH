package com.company.jednostki;

public class Budynek {
    public String Nazwa;
    public int Cena;
    public int budynekZwierzeta;

    public Budynek(int Cena, String Nazwa, int budynekZwierzeta){
        this.Cena = Cena;
        this.Nazwa = Nazwa;
        this.budynekZwierzeta = budynekZwierzeta;
    }
    public String Wypisz()
    {
        return "Nazwa: "+Nazwa+" Cena: "+Cena+" Miejsce na zwirzeta: "+budynekZwierzeta;
    }
}
