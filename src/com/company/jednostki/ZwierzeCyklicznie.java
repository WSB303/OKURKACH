package com.company.jednostki;

public class ZwierzeCyklicznie extends zwierze{
    public ZwierzeCyklicznie(int Cena, String Nazwa,
                             int masa, int doroslosc, int jedzenie, int SzansaRomnozenia, Budynek Budynek,RodzajPozywienia RodzajPozywienia){
        super(Cena, Nazwa, masa, doroslosc, jedzenie,SzansaRomnozenia, Budynek ,RodzajPozywienia);
    }
       public int Zysk(int min, int maks){
        return Losuj(min,maks)*2;
       }

    @Override
    public zwierze Kopiuj() {
        ZwierzeCyklicznie zwierzeCyklicznie = new ZwierzeCyklicznie(
                this.Cena,
        this.Nazwa,
        this.masa,
        this.doroslosc,
        this.jedzenie,
        this.SzansaRomnozenia,
        this.Budynek,
        this.rodzajPozywienia);
        return zwierzeCyklicznie;

    }

    public int Losuj(int minimum, int maksimum)
    {
        return minimum + (int)(Math.random() * maksimum);
    }
}
