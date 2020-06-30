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
    Roslina salata = new Roslina("Sałata",
            10,
            10,
            5,
            1,
            10,
            10,
            40,
            10,
            1);
    rosliny.add(salata);
    Roslina sorgo = new Roslina("Sorgo",
            5,
            5,
            7,
            4,
            48,
            10,
            40,
            10, 15);
    rosliny.add(sorgo);
    Roslina kukurydza = new Roslina("Kukurydza",20,10, 15, 5, 10, 40,48, 10, 7);
    rosliny.add(kukurydza);
    Roslina jablon = new Roslina("Jabłoń",100,8, 3, 5, 10, 106,100, 10, 15);
    rosliny.add(jablon);
    Roslina rukola = new Roslina("Rukola",10, 10, 5, 1, 10, 24,10, 10, 3);
    rosliny.add(rukola);
    }

}
