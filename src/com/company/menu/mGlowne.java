package com.company.menu;

import com.company.jednostki.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mGlowne {
    public static class MenuOpcje
    {
        public static Scanner sc = new Scanner(System.in);

        public static void WbierzOpcjeMenu(int wartosc, List<Farma> farmy, List<Roslina> rosliny, List<Budynek> budynki, List<zwierze> zwierzeta, Farmer farmer)
        {

            int opcjaWyboru = 0;
            switch (wartosc)
            {
                case 1:
                    mWypisywanie.WypisanieWyboru.szablon(mWypisywanie.WypisanieWyboru.OpcjaSklep());
                    opcjaWyboru = sc.nextInt();
                    mSklep.SklepOpcje.WbierzOpcjeSklep(opcjaWyboru, farmy,rosliny,budynki, zwierzeta,farmer);
                    break;
                case 2:
                    mWypisywanie.WypisanieWyboru.szablon(mWypisywanie.WypisanieWyboru.OpcjaSprzedazy());
                    opcjaWyboru = sc.nextInt();
                    mSprzedaz.SprzedazOpcje.WbierzOpcjeSprzedaz(opcjaWyboru,farmer);
                    break;
                case 3:
                    ZbierzRosliny(farmer);
                    break;
                case 4:
                    System.out.println("Ilosc miesa: "+farmer.IloscMiesa+"\nIlosc roslin: "+(farmer.IloscRoslin+farmer.IloscStodola));
                    break;
                case 5:
                    mWypisywanie.WypisanieWyboru.szablon(mWypisywanie.WypisanieWyboru.OpcjaZasoby());
                    opcjaWyboru = sc.nextInt();
                    mZasoby.opcjeZasoby.WybieranieOpcjiZasoby(opcjaWyboru, farmer);
                    break;
                case 6:
                    ZasadzRosliny(farmer);
                    break;
                case 7:
                    PrzerobRoslineNaPasze(farmer);
                    break;
                case 8:
                    farmer.dodajTydzien();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Podana opcja jest niezgodna wybierz jeszcze raz");
                    break;
            }
        }

        //Zebranie roslin na pasze: wyspisej najpierw wszystkie rosliny zebrane. Po wybraniu odpowieniej zwiksza stan roslin w stodole
        //(oczywiscie gdy posiada sie miejsce) a nastepnie roslina zostaje usunieta z listy zebranych roslin.
        public static void PrzerobRoslineNaPasze(Farmer farmer)
        {
            try {
                if(farmer.Farma.ZebraneRosliny.size()!=0) {
                    int opcjaWyboru;
                    String wynik = "Wybierz:\n";
                    for (int i = 0; i < farmer.Farma.ZebraneRosliny.size(); i++) {
                        wynik += "|" + i + "| " + farmer.Farma.ZebraneRosliny.get(i).Wypisz()+"\n";
                    }
                    mWypisywanie.WypisanieWyboru.szablon(wynik);
                    opcjaWyboru = sc.nextInt();
                    if (IloscMiejscaWStodolach(farmer) > farmer.IloscStodola) {
                        if (farmer.Farma.ZebraneRosliny.get(opcjaWyboru).wydajnosc + farmer.IloscStodola <= IloscMiejscaWStodolach(farmer)) {
                            farmer.IloscStodola += farmer.Farma.ZebraneRosliny.get(opcjaWyboru).wydajnosc;
                            farmer.Farma.ZebraneRosliny.remove(opcjaWyboru);
                            System.out.println("Rosline " + farmer.Farma.Rosliny.get(opcjaWyboru).nazwa + " przerobiono na pasze");

                        } else {

                            System.out.println("Zbyt malo miejsca w stodolach");
                        }
                    } else {
                        System.out.println("Zbyt malo miejsca w stodolach");
                    }
                }
                else
                {
                    System.out.println("Brak roslin do przerobienia");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane");
            }

        }
        //Sprawdza ilosc ziemi uprawnej aby stwierdzicz czy jest miejsce na posadzenie nowej
        public static  int IloscZajetejZiemiUprawnej(Farmer farmer) {
            int iloscZajetejZiemi  =0;
            for (Roslina roslina:farmer.Farma.Rosliny
            ) {
                if(roslina.czyposadzona)
                {
                    iloscZajetejZiemi++;
                }
            }
            return iloscZajetejZiemi;
        }
        public static int ZwrocOdpowiednikIndeksu(int []t, int wartosc)
        {
            for(int i=0; i<t.length; i++)
            {
                if(i == wartosc)
                {
                    return i;
                }
            }
            return -1;
        }

        //Zasadz rosline: wypisuje wszystkie rosliny nie zasadzone nastepnie sprawdza czy mozna rosline posadzic
        //i zmienia jej stan na posadzona
        public static void ZasadzRosliny(Farmer farmer)
        {
            try {
                int opcjaWyboru;
                int iterator = 0;
                List<Roslina> roslinyDoPosadzenia = new ArrayList<Roslina>();
                int [] odpowiednikWszystkichRoslin = new int [farmer.Farma.Rosliny.size()];
                for(int i=0; i<farmer.Farma.Rosliny.size(); i++)
                {
                    odpowiednikWszystkichRoslin[i] = -1;
                }
                if(farmer.Farma.Rosliny.size()!=0) {
                    String wynik ="Wybierz roline do zasadzenia:\n";
                    for(int i=0; i<farmer.Farma.Rosliny.size(); i++)
                    {
                        if(!farmer.Farma.Rosliny.get(i).czyposadzona)
                        {
                            wynik += "*"+iterator+"* "+farmer.Farma.Rosliny.get(i).Wypisz()+"\n";
                            roslinyDoPosadzenia.add(farmer.Farma.Rosliny.get(i));
                            odpowiednikWszystkichRoslin[iterator] =i;
                            iterator++;
                        }
                    }
                    mWypisywanie.WypisanieWyboru.szablon(wynik);
                    opcjaWyboru = sc.nextInt();
                    if(IloscZajetejZiemiUprawnej(farmer)<farmer.IloscZiemi  &&
                            farmer.tydzien>= roslinyDoPosadzenia.get(opcjaWyboru).okresOd &&  farmer.tydzien<= roslinyDoPosadzenia.get(opcjaWyboru).okresDo
                            && roslinyDoPosadzenia.get(opcjaWyboru).cenaZbioru<farmer.pieniadze)
                    {
                        farmer.pieniadze -= roslinyDoPosadzenia.get(opcjaWyboru).kosztSadzenia;
                        farmer.Farma.Rosliny.get(odpowiednikWszystkichRoslin[opcjaWyboru]).czyposadzona=true;
                        System.out.println("Roslina zostala posadzona pomyslnie");
                    }
                    else
                    {
                        System.out.println("Nie masz wystarczających zasobow");
                    }
                }
                else
                {
                    System.out.println("Brak roslin do zaszadzenia");
                }

            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane");
            }
        }

        //Znierz Rosliny: wypisuje rosliny ktore mozn zebrac nastepnie usuwa je z listy roslin i przypisuje do roslin juz zebranych
        public static void ZbierzRosliny(Farmer farmer)
        {
            try {
                String wynik = "Wypisz: \n";
                int opcjaWyboru;
                List<Roslina> roslinyDoZbioru = new ArrayList<Roslina>();


                int iterator = 0;
                for (Roslina roslina : farmer.Farma.Rosliny) {
                    if (roslina.obecnytydzien == roslina.czasZbioru) {
                        wynik += "|" + iterator + "| " + roslina.Wypisz()+"\n";
                        iterator++;
                        roslinyDoZbioru.add(roslina);
                    }
                }
                if(iterator==0)
                {
                    System.out.println("Brak elementow do zebrania");
                }
                else
                {

                    mWypisywanie.WypisanieWyboru.szablon(wynik);
                    opcjaWyboru = sc.nextInt();
                    if(farmer.pieniadze>roslinyDoZbioru.get(opcjaWyboru).cenaZbioru)
                    {
                        farmer.Farma.ZebraneRosliny.add(roslinyDoZbioru.get(opcjaWyboru).Kopiuj());
                        farmer.Farma.Rosliny.remove(roslinyDoZbioru.get(opcjaWyboru));
                        System.out.println("Pomyslnie zebrano");
                    }
                    else
                    {
                        System.out.println("Brak wystarczajacych funduszy");
                    }

                }
            }
            catch(Exception ex)
            {
                System.out.println("Bledne dane");
            }

        }
        //Sprawdza ilosc miejsca w stodole aby stwierdzic czy jest miejsce na plony
        public static int IloscMiejscaWStodolach( Farmer farmer)
        {
            int wynik = 0;
            try
            {

                for (Budynek budynek:farmer.Farma.Budynki
                ) {
                    if(budynek.Nazwa.equals("Stodola"))
                    {
                        wynik += budynek.budynekZwierzeta;
                    }

                }
            }
            catch (Exception ex)
            {
                System.out.println("Bledne dane");
            }
            return  wynik;
        }


    }


}