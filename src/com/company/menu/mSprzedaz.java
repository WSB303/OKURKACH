package com.company.menu;
import com.company.jednostki.Farmer;
import com.company.jednostki.ZwierzeNaSprzedaz;
import com.company.jednostki.ZwierzePoCzasie;
import com.company.jednostki.zwierze;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class mSprzedaz {
        public static class SprzedazOpcje{
            public static Scanner sc = new Scanner(System.in);
            public static void WbierzOpcjeSprzedaz(int wartosc, Farmer farmer)
            {
                switch (wartosc)
                {
                    case 1:
                        if(farmer.IloscZiemi !=0)
                        {
                            farmer.pieniadze += 10;
                            farmer.IloscZiemi--;
                        }
                        else
                        {
                            System.out.println("Brak ziemi uprawnej na sprzedaz");
                        }
                        break;
                    case 2:
                        SprzedajZwierze(farmer);
                        break;
                    case 3:
                        SprzedajRosline(farmer);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Podana opcja jest niezgodna wybierz jeszcze raz");
                        break;
                }
            }


            public static void SprzedajZwierze(Farmer farmer)
            {
                int opcjaWyboru;
                List<zwierze> zwirzetaNaSprzedaz = new ArrayList<zwierze>();
//            int [] indeksyZwitrzat = new int [farmer.Farma.Zwierzeta.size()];
//            for(int i=0; i<farmer.Farma.Zwierzeta.size(); i++)
//            {
//                indeksyZwitrzat[i] = -1;
//            }

                int iterator = 0;
                try
                {
                    if(farmer.Farma.Zwierzeta.size()!=0)
                    {
                        String wynik = "wybierz: \n";
                        for(zwierze zwierze : farmer.Farma.Zwierzeta)
                        {
                            if(zwierze instanceof ZwierzeNaSprzedaz && zwierze.aktualnyTydzien<zwierze.doroslosc || (zwierze instanceof ZwierzePoCzasie
                                    && zwierze.aktualnyTydzien>=((ZwierzePoCzasie) zwierze).CzasSprzedazy))
                            {
                                wynik += "|"+iterator+"| "+zwierze.Nazwa+"\n";
                                zwirzetaNaSprzedaz.add(zwierze);
                                iterator++;
                            }
                        }
                        mWypisywanie.WypisanieWyboru.szablon(wynik);
                        opcjaWyboru = sc.nextInt();
                        farmer.pieniadze += zwirzetaNaSprzedaz.get(opcjaWyboru).Cena*0.5;
                        farmer.Farma.Zwierzeta.remove(zwirzetaNaSprzedaz.get(opcjaWyboru));
                    }
                    else
                    {
                        System.out.println("Brak zwierząt na sprzedaż");
                    }
                }
                catch(Exception ex)
                {

                }
            }
            public static void SprzedajRosline(Farmer farmer)
            {
                int opcjaWyboru ;
                try
                {
                    if(farmer.Farma.ZebraneRosliny.size()!=0)
                    {
                        String wynik = "wybierz: \n";
                        for(int i=0; i<farmer.Farma.ZebraneRosliny.size(); i++)
                        {
                            wynik += "|"+i+"| "+farmer.Farma.ZebraneRosliny.get(i).nazwa+"\n";
                        }
                        mWypisywanie.WypisanieWyboru.szablon(wynik);
                        opcjaWyboru = sc.nextInt();

                        farmer.pieniadze += farmer.Farma.ZebraneRosliny.get(opcjaWyboru).wydajnosc*farmer.Farma.ZebraneRosliny.get(opcjaWyboru).cenaSkupu*100;
                        farmer.Farma.ZebraneRosliny.remove(opcjaWyboru);
                        System.out.println("Roslina zostala sprzedana pomyslnie");
                    }
                    else
                    {
                        System.out.println("Brak zasobow do sprzedania");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Nie poprawne dane");
                }
            }
        }
}

