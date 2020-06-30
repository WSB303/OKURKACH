package com.company.menu;

public class mWypisywanie {
    public static class WypisanieWyboru
    {

        public static void szablon(String opcja)
        {
            System.out.println("***********************");
            System.out.println(opcja);
            System.out.println("***********************");
            System.out.print("Wybór: ");
        }
        public static String OpcjaSklep()
        {
            return  "Kup:\n*1* Farma \n*2* Ziemia uprawna Cena:10\n*3* Budynek \n*4* Zwierze \n*5* Roslina\n*6* Jedzenie dla zwierzat \n*7* Powrot";
        }
        public static String OpcjaZasoby()
        {
            return "Wypisz: \n*1* Zwierzeta \n*2* Rosliny \n*3* Powrot";
        }
        public static String OpcjaMenu()
        {
            return "Wybierz Opcje: \n*1* Sklep \n*2* Sprzedaz \n*3* Zbiory \n*4* Stan zapasow \n*5* Informacje o zasobach \n*6* Zasadz rosline\n*7* Przerob rosliny na pasze\n*8* Nastepny tydzien \n*9* Zakoncz";
        }
        public static String OpcjaSprzedazy()
        {
            return "Sprzedaj:\n*1* Ziemia uprawna \n*2* Zwierze \n*3* Roslina \n*4* Powrot";
        }
        public static String OpcjaJedzenie()
        {
            return  "Kup: \n*1* Rosliny\n*2* Mieso\n*3* Powrot";
        }

    }
}
