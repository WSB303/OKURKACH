package com.company.jednostki;

import com.company.bGenerator;
import com.company.rGenerator;
import com.company.zGenerator;

import java.util.List;

public class Farmer {
    public int pieniadze;
    public int rok;
    public int tydzien;
    public boolean wygrana = false;
    public int IloscZiemi;
    public int IloscStodola;
    public int IloscRoslin;
    public int IloscMiesa;
    public Farma Farma;

    public rGenerator generatorRoslin;
    public zGenerator generatorZwierzat;
    public bGenerator generatorBudynkow;

    public Farmer(int pieniadze, int tydzien, int rok)
    {
        this.pieniadze = pieniadze;
        this.tydzien = tydzien;
        this.rok = rok;
        IloscZiemi = 0;
        IloscStodola = 0;
        IloscMiesa = 0;
        IloscStodola = 0;
        generatorBudynkow = new bGenerator();
        generatorRoslin = new rGenerator();
        generatorZwierzat = new zGenerator();
        generatorBudynkow.bWygeneruj();
        generatorRoslin.rGenerowanie();
        generatorZwierzat.zGeneruj(generatorBudynkow.budynki);
    }

    public int Losuj(int min, int maks)
    {
        return min + (int) (Math.random() * maks);
    }
    public int iGatunkiRoslin(List<Roslina> rosliny)
    {
        int ilosc = 0;
        boolean Byl = false;
        for(Roslina roslina: rosliny)
        {
            Byl = false;
            for(Roslina Posiadana: Farma.Rosliny)
            {
                if(!Byl && roslina.nazwa.equals(Posiadana.nazwa)&& Posiadana.czyposadzona)
                {
                    ilosc ++;
                    Byl = true;
                }
            }
        }
        return ilosc;
    }
    public int iGatunkiZwierzat(List<zwierze> zwierzeta)
    {
        int ilosc = 0;
        boolean Byl = false;
        for(zwierze zwierze:zwierzeta)
        {
            Byl=false;
            for(zwierze posiadaneZwierze: Farma.Zwierzeta)
            {
                if(!Byl && zwierze.Nazwa.equals(posiadaneZwierze.Nazwa))
                {
                    ilosc ++;
                    Byl = true;
                }
            }
        }
        return ilosc;
    }
    public boolean jedzenieNaRok()
    {
        int ileMiesa=0;
        int ileRoslin=0;
        for (zwierze zwierze: Farma.Zwierzeta)
        {
            if(zwierze.rodzajPozywienia == zwierze.rodzajPozywienia.mieso)
            {
                ileMiesa += zwierze.jedzenie;
            }else
            {
                ileRoslin += zwierze.jedzenie;
            }

        }
        return ileMiesa*48>=IloscMiesa&& ileRoslin*48>=IloscStodola+IloscRoslin;
    }
    public void dodajTydzien()
    {
        if(tydzien<48)
        {
            tydzien++;
        }else{tydzien=1;rok++;}
        try
        {
            if(IloscZiemi>= 20 && iGatunkiRoslin(generatorRoslin.rosliny)>=5 && iGatunkiZwierzat(generatorZwierzat.zwierzeta)>=5 && jedzenieNaRok())
            {
                System.out.println("Wygrałeś gre.");
                wygrana=true;
            }
            for(Roslina roslina: Farma.Rosliny)
            {
                if(roslina.czyposadzona)
                {
                    pieniadze -= roslina.ochrona;
                    if(roslina.obecnytydzien!=roslina.czasZbioru)
                    {
                        roslina.obecnytydzien++;
                    }
                    else {roslina.czydozebrania=true;}
                }
            }
            for (zwierze zwierze:Farma.Zwierzeta)
            {// instanceof sprawdza czy obiekt jest podtypem
                if(zwierze instanceof ZwierzeCyklicznie)
                {
                    pieniadze+=((ZwierzeCyklicznie) zwierze).Zysk(0,10);
                }
                zwierze.aktualnyTydzien++;
                if(zwierze.aktualnyTydzien>=zwierze.doroslosc&& tenSamTyp(zwierze)>=1)
                {
                    int szansa = Losuj(0,100);

                    if(szansa>=0&&szansa<=zwierze.SzansaRomnozenia)
                    {
                        System.out.println("Urodził się "+ zwierze.Nazwa);
                        zwierze zwierzeDziecko = zwierze.Kopiuj();
                        zwierzeDziecko.obecnaMasa=0;
                        zwierzeDziecko.aktualnyTydzien=0;
                        Farma.Zwierzeta.add(zwierzeDziecko);
                    }


                }

                if(IloscMiesa>zwierze.jedzenie&&zwierze.rodzajPozywienia.equals(zwierze.rodzajPozywienia.mieso))
                {
                    IloscMiesa-=zwierze.jedzenie;
                    zwierze.obecnaMasa+=zwierze.masa;
                }
                else if(IloscStodola>zwierze.jedzenie&&zwierze.rodzajPozywienia.equals(zwierze.rodzajPozywienia.rosliny))
                {
                    IloscStodola -= zwierze.jedzenie;
                    zwierze.obecnaMasa += zwierze.masa;
                }
                else if(IloscRoslin>zwierze.jedzenie&&zwierze.rodzajPozywienia.equals(zwierze.rodzajPozywienia.rosliny))
                {
                    IloscRoslin -= zwierze.jedzenie;
                    zwierze.obecnaMasa += zwierze.masa;
                }
                else
                {
                    System.out.println("Nie masz jedzenia!");
                    zwierze.obecnaMasa -= zwierze.masa;
                    if (zwierze.obecnaMasa < 0)
                    {
                        System.out.println("Nie nakarmiles zwierząt... Zwierze: " + zwierze.Nazwa + " umarło");
                        Farma.Zwierzeta.remove(zwierze);
                    }

                }
            }

            int losowanie=Losuj(0,50);
            if(losowanie==1)
            {
                System.out.println("Robaki zaatakowały Twoje plony!");
                Farma.ZebraneRosliny.clear();
            }
        } catch (Exception ex){ System.out.println(""); }
    }




    public int tenSamTyp(zwierze zwierze)
    {
        int wynik=0;
        try
        {
            for(zwierze zwierzeta: Farma.Zwierzeta)
            {
            if(zwierzeta.Nazwa.equals(zwierze.Nazwa))
            {
                wynik++;
            }
            }
        }catch (Exception ex)
        {
            System.out.println("Błąd");
        }
        return wynik/2;
    }
}
