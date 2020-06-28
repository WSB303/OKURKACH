package com.company.jednostki;

public class zwierze {
    public int Cena;
    public String Nazwa;
    public int masa;
    public int obecnaMasa;
    public int doroslosc;
    public int aktualnyTydzien;
    public int jedzenie;
    public int SzansaRomnozenia;
    public Budynek Budynek;
    public RodzajPozywienia rodzajPozywienia;
    public zwierze(int Cena, String Nazwa,
                   int masa, int doroslosc, int jedzenie, int SzansaRomnozenia,
                   Budynek Budynek,RodzajPozywienia RodzajPozywienia){
        this.Cena = Cena;
        this.Nazwa = Nazwa;
        this.masa = masa;
        this.doroslosc = doroslosc;
        this.jedzenie = jedzenie;
        this.SzansaRomnozenia = SzansaRomnozenia;
        this.Budynek = Budynek;
        this.rodzajPozywienia = RodzajPozywienia;
        obecnaMasa = 0;
        aktualnyTydzien = 0;
    }
    public String Wypisz()
    {
        return "Nazwa: "+Nazwa+" Cena: "+Cena+" Dobor masy: "+masa+" Obecna masa: "+obecnaMasa+" Czas doroslosci: "+doroslosc+" Ilosc jedzenia: "
                +jedzenie+" Szansa na rozmnozenie: "+SzansaRomnozenia+"% Aktualny tydzień: "+aktualnyTydzien;
    }
    public zwierze Kopiuj()
    {
        return new zwierze( Cena, Nazwa, masa,
                doroslosc, jedzenie,SzansaRomnozenia,
                Budynek ,rodzajPozywienia);
    }
    public static enum RodzajPozywienia
    {
        rosliny,
        mieso
    }
}

