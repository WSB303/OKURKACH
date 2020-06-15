package com.company;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

import static com.company.start.menu.choose;


public class START {
    public static String name;
    public static Integer option;
    public START() {
        System.out.println("Witam, na start chce dowiedzieć się jak masz na imie. ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        Player player1 = new Player(START.name, 10);
        System.out.println("Dobrze " + name + ". Teraz wylosujemy dla Ciebie farmy, które będziesz mógł wybrać na początek.");
        Farms[] farm = new Farms[5];
        farm[4] = new Farms("1.Small farma", 1.0, 1);
        farm[3] = new Farms("2.Medium farm", 15.0, 4);
        farm[2] = new Farms("3.Big farm", 20.0, 3);
        farm[1] = new Farms("4.Super farm", 25.0, 4);
        farm[0] = new Farms("5.Exclusive farm", 30.0, 5);
        Random r = new Random();
        for(int i = 1; i<4;i++) {
            for (int j = 0; j < i; j++) {
                int a = r.nextInt(5);
                System.out.println(farm[a]);
            }
        }

        try {
            System.out.println("Wpisz początkowy numer farmy, aby ją wybrać.");
            option = Integer.valueOf(in.nextLine());
            if (option <= 5) {
                switch (option) {
                    case 1:
                        System.out.println("Wybrałeś farme Small");
                        player1.setFarm(farm[4], 1);
                        System.out.println("Naciśnij klawisz aby kontynuować.");
                        in.nextLine();
                        choose();
                        break;
                    case 2:
                        System.out.println("Wybrałeś farme Medium");
                        player1.setFarm(farm[3], 1);
                        System.out.println("Naciśnij klawisz aby kontynuować.");
                        in.nextLine();
                        choose();
                        break;
                    case 3:
                        System.out.println("Wybrałeś farme Big");
                        player1.setFarm(farm[2], 1);
                        System.out.println("Naciśnij klawisz aby kontynuować.");
                        in.nextLine();
                        choose();
                        break;
                    case 4:
                        System.out.println("Wybrałeś farme Super");
                        player1.setFarm(farm[1], 1);
                        System.out.println("Naciśnij klawisz aby kontynuować.");
                        in.nextLine();
                        choose();
                        break;
                    case 5:
                        System.out.println("Wybrałeś farme Exclusive");
                        player1.setFarm(farm[0], 1);
                        System.out.println("Naciśnij klawisz aby kontynuować.");
                        in.nextLine();
                        choose();
                        break;
                }
            } else {
                System.out.println("Błąd");
            }
        }catch (Exception ex) {
            System.err.println("This is not a number!");
            new START();
        }
    }

}