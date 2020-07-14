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
            ZwierzeCyklicznie owca = new ZwierzeCyklicznie(100,"Owca",1,10,2,10,budynki.get(1), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)owca);
            ZwierzeCyklicznie kura = new ZwierzeCyklicznie(100,"kura",1,10,2,15,budynki.get(2), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)kura);
            ZwierzeCyklicznie pies = new ZwierzeCyklicznie(100,"pies",1,10,2,30,budynki.get(0), zwierze.RodzajPozywienia.mieso);
            zwierzeta.add((zwierze)pies);
            ZwierzeCyklicznie swinia = new ZwierzeCyklicznie(100,"swinia",1,10,2,10,budynki.get(3), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)swinia);
            ZwierzeCyklicznie kon = new ZwierzeCyklicznie(100,"kon",1,10,2,25,budynki.get(2), zwierze.RodzajPozywienia.rosliny);
            zwierzeta.add((zwierze)kon);

        }

}
