package com.company.menu;

import java.util.Scanner;

public class mGlowne {
    public static class Menu{
        public static Scanner sc = new Scanner(System.in);
        public static void Choose(int wartosc)
        {
            int opction = 0;
            switch (wartosc)
            {
                case 1:
                    opction = sc.nextInt();
                    break;
                case 2:
                    opction = sc.nextInt();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    opction = sc.nextInt();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Zła opcja, wybierz jeszcze raz.");
                    break;
            }
        }







    }
}
