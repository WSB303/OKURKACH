package com.company;
import com.company.jednostki.Budynek;
import com.company.jednostki.ZwierzeCyklicznie;
import com.company.jednostki.zwierze;

import java.util.ArrayList;
import java.util.List;

public class zGenerator {
    public List<zwierze> zwierzeta;
    public zGenerator(){ zwierzeta = new ArrayList<zwierze>();}
    public void zGeneruj(List<Budynek> budynki)
        {
            ZwierzeCyklicznie owca = new ZwierzeCyklicznie(100,"Owca",1,10,2,50,budynki.get(1), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)owca);
            ZwierzeCyklicznie kura = new ZwierzeCyklicznie(100,"Owca",1,10,2,50,budynki.get(1), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)kura);
            ZwierzeCyklicznie pies = new ZwierzeCyklicznie(100,"Owca",1,10,2,50,budynki.get(1), zwierze.RodzajPozywienia.mieso);
            zwierzeta.add((zwierze)pies);
            ZwierzeCyklicznie swinia = new ZwierzeCyklicznie(100,"Owca",1,10,2,50,budynki.get(1), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)swinia);
            ZwierzeCyklicznie krowa = new ZwierzeCyklicznie(100,"Owca",1,10,2,50,budynki.get(1), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)krowa);

        }

}
