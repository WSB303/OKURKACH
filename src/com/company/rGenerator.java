package com.company;

import com.company.jednostki.Roslina;

import java.util.ArrayList;
import java.util.List;

public class rGenerator {
    public List<Roslina> rosliny;
    public rGenerator()
    {
        rosliny = new ArrayList<Roslina>();
    }
    public void rGenerowanie(){
    Roslina salata = new Roslina("Sałata",5,5,5,5,5,5,5,5,5);
    rosliny.add(salata);
    Roslina sorgo = new Roslina("Sorgo",5,5,5,5,5,5,5,5,5);
    rosliny.add(sorgo);
    Roslina kukurydza = new Roslina("Kukurydza",5,5,5,5,5,5,5,5,5);
    rosliny.add(kukurydza);
    Roslina jablon = new Roslina("Jabłoń",5,5,5,5,5,5,5,5,5);
    rosliny.add(jablon);
    Roslina rukola = new Roslina("Rukola",5,5,5,5,5,5,5,5,5);
    rosliny.add(rukola);
    }

}
