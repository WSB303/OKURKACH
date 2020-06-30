package com.company;

import com.company.jednostki.Farmer;
import com.company.jednostki.Roslina;

import java.util.List;

import static com.company.jednostki.zwierze.RodzajPozywienia.rosliny;

public class wypisywanieDanych {
    public static class rWypisywanie {
        //wypisywanie roślin wygenerowanych
        public static void WypiszRoslinyKupne(List<Roslina> rosliny) {
            for (int i = 0; i < rosliny.size(); i++) {
                System.out.println("|" + i + "| Roslina: " + rosliny.get(i).Wypisz());
            }
            System.out.println("-----------------------");
            System.out.print("Opcja:");
        }

        //wypisywanie posiadanych roslin
        public static void WypiszRoslinyPosiadane(Farmer farmer) {
            if (farmer.Farma != null) {
                for (int i = 0; i < farmer.Farma.Rosliny.size(); i++) {
                    System.out.println("|" + i + "| " + farmer.Farma.Rosliny.get(i).Wypisz() + " Zasadzona: " + farmer.Farma.Rosliny.get(i).czyposadzona);
                }
            } else {
                System.out.println("Brak zasobów. ");
            }
        }
    }
    public static class zWypisywanie
    {
        public static void WypiszZwierzetaPosiadane(Farmer farmer)
        {
            try
            {
                for(int i=0;i<farmer.Farma.Zwierzeta.size();i++)
                {
                    System.out.println("|"+i+"| "+farmer.Farma.Zwierzeta.get(i).Wypisz());
                }
            }catch (Exception ex){
                System.out.println("Nie masz zwierząt.");
            }
        }
    }
}