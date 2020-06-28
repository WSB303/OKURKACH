package com.company;

import com.company.jednostki.Budynek;

import java.util.ArrayList;
import java.util.List;

public class bGenerator {
    public List<Budynek> budynki;
    public bGenerator()
    {
        budynki = new ArrayList<Budynek>();
    }
    public void bWygeneruj()
    {
        Budynek stodola = new Budynek(100, "Stodola", 500);
        budynki.add(stodola);
        Budynek buda = new Budynek(100, "Buda",4);
        budynki.add(buda);
        Budynek kurnik = new Budynek(100, "Kurnik",30);
        budynki.add(kurnik);
        Budynek obora = new Budynek(100, "Obora",10);
        budynki.add(obora);
        Budynek chlew = new Budynek(100, "Chlew", 20);
        budynki.add(chlew);
    }
}
