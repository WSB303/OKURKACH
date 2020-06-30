package com.company.menu;

import com.company.jednostki.Farmer;

import java.util.Scanner;

public class mJedzenie {
    public static  class JezdenieDlaZwierzatOpcje
    {
        Scanner sc = new Scanner(System.in);
        public static void WybierzOpcjeJedzenieDlaZwierzat(int wartosc, Farmer farmer)
        {
            switch (wartosc)
            {
                case 1:
                    KupRosliny(farmer);
                    break;
                case 2:
                    KupMieso(farmer);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Dane z poza zakresu");
                    break;
            }
        }
        //Metoda do kupowania roslin
        public static void KupRosliny(Farmer farmer)
        {
            if(farmer.pieniadze>50)
            {
                farmer.IloscRoslin+=10;
                farmer.pieniadze -= 50;
            }
            else
            {
                System.out.println("Brak funduszy");
            }
        }

        //Matoda do kupowania miesa
        public static void KupMieso(Farmer farmer)
        {
            if(farmer.pieniadze>50)
            {
                farmer.IloscMiesa+=10;
                farmer.pieniadze -= 50;
            }
            else
            {
                System.out.println("Brak funduszy");
            }
        }
    }
}
