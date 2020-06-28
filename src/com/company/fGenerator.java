package com.company;

import com.company.jednostki.Farma;

import java.util.ArrayList;
import java.util.List;

public class fGenerator {
    public List<Farma> farmy;
    public fGenerator() { farmy = new ArrayList<Farma>();}
    public void fGeneruj(int iloscfarm, int minWielkosc, int makswielkosc,int maksbudynkow, int minbudynkow, int minCena, int maksCena){
        for(int i=0; i<iloscfarm;i++){
            int wielkosc = Losuj(minWielkosc, makswielkosc);
            int iloscBudynkow = Losuj(minbudynkow,maksbudynkow);
            int cena = Losuj(minCena,maksCena);
            Farma farma = new Farma(wielkosc,iloscBudynkow,cena);
            farmy.add(farma);
        }
    }
    public int Losuj(int min, int maks)
    {
        return min + (int)(Math.random() * maks);
    }

}
