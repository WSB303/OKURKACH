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
            if(zwierze.rodzajPozywienia+=zwierze.)
            {
                IloscMiesa += zwierze.
            }
        }
    }

}
