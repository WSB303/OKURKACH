package com.company.jednostki;

import java.util.ArrayList;
import java.util.List;

public class Farma {
    public int Wielkosc;
    public int Cena;
    public int IloscBudynkow;
    public boolean Kupiona;
    public List<Roslina> Rosliny;
    public List<zwierze> Zwierzeta;
    public List<Budynek> Budynki;
    public List<Roslina> ZebraneRosliny;

    public Farma(int Wielkosc, int IloscBudynkow, int Cena)
    {
        Budynki = new ArrayList<Budynek>();
        Rosliny = new ArrayList<Roslina>();
        Zwierzeta = new ArrayList<zwierze>();
        ZebraneRosliny = new ArrayList<Roslina>();

        Kupiona = false;
        this.IloscBudynkow = IloscBudynkow;
        this.Cena = Cena;
        this.Wielkosc = Wielkosc;

    }
    public String Wypisz()
    {
        return "Wielkosc farmy: "+Wielkosc+" Ilosc budynkow: "+IloscBudynkow+" Cena: "+Cena;

    }
}

