package com.company.start;
import java.util.Scanner;

public class menu {
    public static Integer option;
    public static void choose() {

        try {
            System.out.println("---------------------------------");
            System.out.println("|1. Nakarm zwierzę              |");
            System.out.println("|2. Zabij zwierzę               |");
            System.out.println("|3. Nasraj mu na głowe          |");
            System.out.println("|4. Kapiszon                    |");
            System.out.println("|5. Kupsko                      |");
            System.out.println("|6. Popaca                      |");
            System.out.println("|                               |");
            System.out.println("|                               |");
            System.out.println("|                               |");
            System.out.println("|                               |");
            System.out.println("---------------------------------");
            Scanner in = new Scanner(System.in);
            option = Integer.valueOf(in.nextLine());
            switch (option){
                case 1:
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
            }

        }catch (Exception ex){
            System.out.println("Błąd!");
        }
    }

}
