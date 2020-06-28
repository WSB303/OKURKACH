package com.company.jednostki;

public class ZwierzeNaSprzedaz extends zwierze{
    public ZwierzeNaSprzedaz(int Cena, String Nazwa,
                             int masa, int doroslosc, int jedzenie, int SzansaRomnozenia, Budynek Budynek,RodzajPozywienia RodzajPozywienia){
        super(Cena, Nazwa, masa, doroslosc, jedzenie,SzansaRomnozenia, Budynek ,RodzajPozywienia);
    }
    @Override
    public zwierze Kopiuj() {
        ZwierzeNaSprzedaz zwierzeNaSprzedaz= new ZwierzeNaSprzedaz(
                this.Cena,
                this.Nazwa,
                this.masa,
                this.doroslosc,
                this.jedzenie,
                this.SzansaRomnozenia,
                this.Budynek,
                this.rodzajPozywienia);
        return zwierzeNaSprzedaz;

    }
}
