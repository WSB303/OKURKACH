package com.company.jednostki;

public class zwierze {
    public int Cena;
    public String Nazwa;
    public int masa;
    public int obecnaMasa;
    public int doroslosc;
    public int aktualnyTydzien;
    public int jedzenie;
    public int szansaRomnozenia;
    public Budynek Budynek;
    public RodzajPozywienia rodzajPozywienia;
    public zwierze(int Cena, String Nazwa,
                   int masa, int obecnaMasa,
                   int doroslosc,int aktualnyTydzien,
                   int jedzenie, int szansaRomnozenia,
                   Budynek Budynek,RodzajPozywienia RodzajPozywienia){
        this.Cena = Cena;
        this.Nazwa = Nazwa;
        this.masa = masa;
        this.doroslosc = doroslosc;
        this.jedzenie = jedzenie;
        this.szansaRomnozenia = szansaRomnozenia;
        this.Budynek = Budynek;
        this.rodzajPozywienia = RodzajPozywienia;
        obecnaMasa = 0;
        aktualnyTydzien = 0;
    }
    public zwierze(){

    }
    public String Wypisz()
    {
        return "Nazwa: "+Nazwa+" Cena: "+Cena+" Dobor masy: "+masa+" Czas doroslosci: "+doroslosc+" Ilosc jedzenia: "
                +jedzenie+" Szansa na rozmnozenie: "+szansaRomnozenia+"% Aktualny tydzień: "+aktualnyTydzien;
    }
    public zwierze Kopiuj()
    {
        return this;
    }
    public static enum RodzajPozywienia
    {
        rosliny,
        mieso
    }
}

