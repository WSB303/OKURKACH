package com.company.jednostki;

public class ZwierzePoCzasie extends zwierze {
    public int CzasSprzedazy;
    public int Czas;

    public ZwierzePoCzasie(int Cena, String Nazwa,
                           int masa, int doroslosc, int jedzenie, int SzansaRomnozenia, Budynek Budynek, RodzajPozywienia RodzajPozywienia, int CzasSprzedazy) {
        super(Cena, Nazwa, masa, doroslosc, jedzenie, SzansaRomnozenia, Budynek, RodzajPozywienia);
        this.CzasSprzedazy = 1;
        Czas = 1;
    }
    @Override
    public String Wypisz() {
        return super.Wypisz()+" Czas do sprzedaży: "+CzasSprzedazy;
    }
    @Override
    public zwierze Kopiuj() {
        ZwierzePoCzasie zwierzePoCzasie = new ZwierzePoCzasie(
                this.Cena,
                this.Nazwa,
                this.masa,
                this.doroslosc,
                this.jedzenie,
                this.SzansaRomnozenia,
                this.Budynek,
                this.rodzajPozywienia,
                this.CzasSprzedazy);
        return zwierzePoCzasie;

    }
}