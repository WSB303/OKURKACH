package com.company;


import com.company.jednostki.Farmer;
import com.company.menu.mGlowne;
import com.company.menu.mWypisywanie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Farmer farmer = new Farmer(200000,1,2020);
        int WyborMenu=0;
        fGenerator generatorFarm = new fGenerator();
        generatorFarm.fGeneruj(10,10,100,2,5,100,1000);
        rGenerator generatorRoslin = new rGenerator();
        generatorRoslin.rGenerowanie();
        bGenerator generatorBudynkow = new bGenerator();
        generatorBudynkow.bWygeneruj();
        zGenerator generatorZwierzat = new zGenerator();
        generatorZwierzat.zGeneruj(generatorBudynkow.budynki);
        while (WyborMenu != 9 || farmer.wygrana)
        {
            System.out.println("Pieniadze: "+farmer.pieniadze+" data: "+farmer.tydzien+" tydzien "+farmer.rok);
            //Wpisanie menu
            mWypisywanie.WypisanieWyboru.szablon(mWypisywanie.WypisanieWyboru.OpcjaMenu());
            //Pobranie wartosci
            WyborMenu = sc.nextInt();
            //Dzialanie na wybrana opcje z menu
            mGlowne.MenuOpcje.WbierzOpcjeMenu(WyborMenu, generatorFarm.farmy,generatorRoslin.rosliny,generatorBudynkow.budynki,generatorZwierzat.zwierzeta, farmer);
        }


    }
}
