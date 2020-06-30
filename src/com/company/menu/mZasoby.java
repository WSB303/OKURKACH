package com.company.menu;

import com.company.jednostki.Farmer;
import com.company.wypisywanieDanych;

public class mZasoby {
    public static class opcjeZasoby
    {
        public static void WybieranieOpcjiZasoby(int wartosc, Farmer farmer)
        {
            switch (wartosc)
            {
                case 1:
                    wypisywanieDanych.zWypisywanie.WypiszZwierzetaPosiadane(farmer);
                    break;
                case 2:
                    wypisywanieDanych.rWypisywanie.WypiszRoslinyPosiadane(farmer);
                    break;
                default:
                    System.out.println("Wybrałeś złą opcję, spróbuj jeszcze raz.");
                    break;
            }
        }
    }
}
