package com.company.jednostki;

public class Roslina {
    public String nazwa;
    public int cenaRosliny;
    public int kosztSadzenia;
    public int ochrona;
    public int wydajnosc;
    public int okresOd;
    public int okresDo;
    public int czasZbioru;
    public int cenaZbioru;
    public int cenaSkupu;
    public boolean czyposadzona;
    public boolean czydozebrania;
    public int obecnytydzien;

    public Roslina(
            String nazwa,
            int cenaRosliny,
            int kosztSadzenia,
            int ochrona,
            int wydajnosc,
            int czasZbioru,
            int okresOd,
            int okresDo,
            int cenaZbioru,
            int cenaSkupu)
    {
        this.nazwa = nazwa;
        this.cenaRosliny = cenaRosliny;
        this.kosztSadzenia = kosztSadzenia;
        this.ochrona = ochrona;
        this.wydajnosc = wydajnosc;
        this.czasZbioru = czasZbioru;
        this.okresOd = okresOd;
        this.okresDo = okresDo;
        this.cenaZbioru = cenaZbioru;
        this.cenaSkupu = cenaSkupu;
        czydozebrania = false;
        czyposadzona = false;
        obecnytydzien = 1;
    }

    public Roslina Kopiuj()//tworzy nowy obiekt, przy edycji nie edytują się wszystkie tylko pojedyńcze
    {
        return new Roslina( nazwa,
                cenaRosliny,
                kosztSadzenia,
                ochrona,
                wydajnosc,
                czasZbioru,
                okresOd,
                okresDo,
                cenaZbioru,
                cenaSkupu);
    }

    public String Wypisz()
    {
        return "Nazwa: "+nazwa+" Cena za sadzonke: "+cenaRosliny+" Koszt sadzenia: "+kosztSadzenia+" Koszt ochrony: "+
                ochrona+" Wydajnosc: "+wydajnosc+" Dlugosc do zbioru: "+ czasZbioru+" Tygodnie siania: "+okresOd+
                "-"+okresDo+" Koszt zbioru: "+cenaZbioru+" Cena skupu: "+cenaSkupu;
    }

}
