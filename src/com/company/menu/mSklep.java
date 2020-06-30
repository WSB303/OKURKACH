package com.company.menu;

import com.company.jednostki.*;
import com.company.wypisywanieDanych;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mSklep {
    //Klasa odpowiedzialna za wybór wszelkich opcji w Menu sklepu i za ich działanie
    public static class SklepOpcje
    {
        public static Scanner sc = new Scanner(System.in);
        public static   int opcjaWyboru;

        public static void WbierzOpcjeSklep(int wartosc, List<Farma> farmy, List<Roslina> rosliny, List<Budynek> budynki, List<zwierze> zwierzeta, Farmer farmer)
        {
            switch (wartosc)
            {
                case 1:
                    ZakupFarmy(farmer,farmy);
                    break;
                case 2:
                    ZakupZiemi(farmer);
                    break;
                case 3:
                    ZakupBudynku(farmer, budynki);
                    break;
                case 4:
                    ZakupZwierzat(farmer, zwierzeta);
                    break;
                case 5:
                    ZakupRoslin(farmer,rosliny);
                    break;
                case 6:
                    //Case wywolujacy pole wyboru jedzenia dla zwirzat
                    mWypisywanie.WypisanieWyboru.szablon(mWypisywanie.WypisanieWyboru.OpcjaJedzenie());
                    opcjaWyboru = sc.nextInt();
                    mJedzenie.JezdenieDlaZwierzatOpcje.WybierzOpcjeJedzenieDlaZwierzat(opcjaWyboru, farmer);
                    break;
                case 7:
                    //case cofania
                    break;
                default:
                    System.out.println("Podana opcja jest niezgodna wybierz jeszcze raz");
                    break;
            }
        }

        //ten case odpowiada za zakup framy. Sprawdza czy jest wystarczajaco pieniedzy oraz czy jest juz zakupiona
        //w takim przypadku nie mozna kupic w try obsluguje wyjatek gdy głownie jest zle podany zakres tablicy
        public static void ZakupFarmy(Farmer farmer, List<Farma> farmy)
        {
            String wynik ="";
            for(int i=0; i<farmy.size(); i++)
            {
                wynik +="|"+i+"| "+farmy.get(i).Wypisz()+"\n";
            }
            if (CzyFarmaZkupiona(farmer))
            {
                System.out.println("Posiadasz juz zakupiona farme");
            }
            else
            {
                mWypisywanie.WypisanieWyboru.szablon(wynik);

                try
                {
                    opcjaWyboru = sc.nextInt();
                    if(farmy.get(opcjaWyboru).Cena>farmer.pieniadze)
                    {
                        System.out.println("Nie masz wystarczająco srodkow do zakupu tej farmy");
                    }
                    else
                    {
                        farmy.get(opcjaWyboru).Kupiona = true;
                        farmer.pieniadze -= farmy.get(opcjaWyboru).Cena;
                        farmer.Farma = farmy.get(opcjaWyboru);
                        System.out.println("Farma zaostala zakupiona");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Dane z poza zakresy. Sprobuj jeszcze raz.");
                }

            }

        }
        //Zakup Ziemi uprawnej
        public static void ZakupZiemi(Farmer farmer)
        {
            if(farmer.pieniadze>10)
            {
                farmer.IloscZiemi++;
                farmer.pieniadze -= 10;
            }
            else
            {
                System.out.println("Brak funduszy");
            }
        }

        //Zakup budynku: wypisuje wszystkie dostepne budynki następnie dodaje je do listy znajdującej się w klasie Farmer.Farma
        //Sprawdzany jest warunek czy jest wystarczajaca ilosc pieniedzy oraz czy jest odpowiednia ilosc budynkow zgodnie z
        //danymi zakupionej Farmy. Obsługa wyjątku głównie jest do obsługi braku farmy.
        public static void ZakupBudynku(Farmer farmer, List<Budynek> budynki)
        {
            String wynik ="Wybierz: \n";

            for(int i=0; i<budynki.size(); i++)
            {
                wynik += "|"+i+"| "+budynki.get(i).Wypisz()+"\n";
            }
            mWypisywanie.WypisanieWyboru.szablon(wynik);

            try
            {
                opcjaWyboru = sc.nextInt();
                if(farmer.pieniadze>budynki.get(opcjaWyboru).Cena && farmer.Farma.IloscBudynkow>farmer.Farma.Budynki.size())
                {
                    farmer.pieniadze -= budynki.get(opcjaWyboru).Cena;
                    farmer.Farma.Budynki.add(budynki.get(opcjaWyboru));
                }
                else
                {
                    System.out.println("Brak funduszy, lub miejsca");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Niepoprawne dane");
            }

        }
        //Zakup zwierzat: Najpierw wypisuje zwierzeta do zakupu, Potem sprawdza Czy dobrze jest z pieniedzmi oraz czy jest miejsce
        //w budynku jak warunek jest zgodny odejmuje od puli pieniedzy cena zakupu oraz dodaje zwierzeta na liste. Try głównie jak nie ma
        //farmy.
        public  static  void ZakupZwierzat(Farmer farmer, List<zwierze> zwierzeta) {
            try {
                String wynik = "Kup:" + farmer.Farma.Budynki.size() + " \n";
                for (int i = 0; i < zwierzeta.size(); i++) {
                    wynik += "|" + i + "| " + zwierzeta.get(i).Wypisz() + "\n";
                }
                mWypisywanie.WypisanieWyboru.szablon(wynik);

                opcjaWyboru = sc.nextInt();
                if (farmer.pieniadze > zwierzeta.get(opcjaWyboru).Cena && CzyJestMiejsceWBudynku(farmer, zwierzeta.get(opcjaWyboru))) {
                    farmer.pieniadze -= zwierzeta.get(opcjaWyboru).Cena;

                    zwierze zwierzeDoKupienia = zwierzeta.get(opcjaWyboru).Kopiuj();

                    farmer.Farma.Zwierzeta.add((zwierze) zwierzeDoKupienia);
                    System.out.println("Zwierze zakupiono pomyslnie");
                } else {
                    System.out.println("Brak zasobow");
                }
            } catch (Exception ex) {
                System.out.println("Bledne dane");
            }
        }

        public static  void  ZakupRoslin(Farmer farmer, List<Roslina> rosliny)
        {
            wypisywanieDanych.rWypisywanie.WypiszRoslinyKupne(rosliny);

            try
            {
                opcjaWyboru = sc.nextInt();
                if(rosliny.get(opcjaWyboru).cenaRosliny>farmer.pieniadze)
                {
                    System.out.println("Nie posiadasz wystarczająco funduszy");
                }
                else
                {

                    Roslina zakupionaRoslina = new Roslina(rosliny.get(opcjaWyboru).nazwa, rosliny.get(opcjaWyboru).cenaRosliny, rosliny.get(opcjaWyboru).kosztSadzenia,
                            rosliny.get(opcjaWyboru).ochrona, rosliny.get(opcjaWyboru).wydajnosc, rosliny.get(opcjaWyboru).czasZbioru,
                            rosliny.get(opcjaWyboru).okresOd, rosliny.get(opcjaWyboru).okresDo, rosliny.get(opcjaWyboru).cenaZbioru, rosliny.get(opcjaWyboru).cenaSkupu);
                    farmer.Farma.Rosliny.add(zakupionaRoslina);
                    farmer.pieniadze -= rosliny.get(opcjaWyboru).cenaRosliny;
                }
            }
            catch(Exception e)
            {
                System.out.println("Dane z poza zakresy. Sprobuj jeszcze raz.");
            }
        }
        //Metoda sprawdza czy farma jest juz zakupiona
        public static boolean CzyFarmaZkupiona(Farmer farmer)
        {
            return farmer.Farma != null;
        }

        //Metoda sprawdza czy jest miejsce w budynku dla zwirzatka
        public static boolean CzyJestMiejsceWBudynku(Farmer farmer, zwierze zwierze)
        {

            int iloscZwirzat = 0;
            int iloscMiejscaWBudynku =0 ;
            for (zwierze zwierzeta: farmer.Farma.Zwierzeta) {
                if(zwierzeta.Budynek == zwierze.Budynek)
                {
                    iloscZwirzat++;
                }
            }

            for (Budynek budynek:farmer.Farma.Budynki) {

                if(budynek == zwierze.Budynek)
                {
                    iloscMiejscaWBudynku += budynek.budynekZwierzeta;
                }
            }
            if(iloscZwirzat<iloscMiejscaWBudynku)
            {
                return true;
            }

            return false;
        }



    }
}

