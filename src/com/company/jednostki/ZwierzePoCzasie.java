package com.company.jednostki;

public class ZwierzePoCzasie extends zwierze{
    public int CzasSprzedazy;
    public int Czas;
    public ZwierzePoCzasie(int Cena, String Nazwa,
                           int masa, int doroslosc, int jedzenie, int SzansaRomnozenia, Budynek Budynek,RodzajPozywienia RodzajPozywienia, int CzasSprzedazy){
        super(Cena, Nazwa, masa, doroslosc, jedzenie,SzansaRomnozenia, Budynek ,RodzajPozywienia);
        this.CzasSprzedazy = 1;
        Czas = 1;
    }

}
