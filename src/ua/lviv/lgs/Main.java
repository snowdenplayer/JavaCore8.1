package ua.lviv.lgs;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("Press 1 if you want to check that months exist");
        System.out.println("Press 2 if you want to print all mounth with the same seasson");
        System.out.println("Press 3 if you want to print all mounths that have the same number" + " of days");
        System.out.println("Press 4 if you want to print all mounths that have minimal number of day");
        System.out.println("Press 5 if you want to print all mounths that have maximal number of day");
        System.out.println("Press 6 if you want to print next seasson");
        System.out.println("Press 7 if you want to print previous seasson");
        System.out.println("Press 8 if you want to print all mounths that have even number of days");
        System.out.println("Press 9 if you want to  print all mounths that have odd number of days");
        System.out.println("Press 10 if you want know that mounth has even number of days");

    }

    public static void main(String[] args) {
        Month[] months = Month.values();
        Seassons[] seassons = Seassons.values();


        Scanner in = new Scanner(System.in);
        while (true) {
            menu();
            switch (in.next()) {
                case "1": {
                    in = new Scanner(System.in);
                    String month = in.next();
                    boolean flag = isMonthPresent(months, month);
                    if (!flag) {
                        System.out.println("Doesnt exist");
                    }
                    break;
                }

                case "2": {
                    System.out.println("Enter seasson");
                    in = new Scanner(System.in);
                    String directionSe = in.next();

                    boolean flag = false;

                    for (Month mon : months) {
                        if (mon.getSeassons().name().equalsIgnoreCase(directionSe)) {
                            flag = true;

                        }
                    }
                    if (flag == true) {

                        for (Month mounth : months) {
                            if (mounth.getSeassons().toString().equalsIgnoreCase(directionSe)) {
                                System.out.println(mounth);
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("Mounth doesen`t exist");

                    }

                    break;
                }

                case "3": {
                    System.out.println("Enter days");
                    in = new Scanner(System.in);
                    int days = in.nextInt();

                    boolean flag = false;

                    for (Month mon : months) {
                        if (mon.getDays() == days) {
                            flag = true;

                        }
                    }
                    if (flag == true) {

                        for (Month mounth : months) {
                            if (mounth.getDays() == days) {
                                System.out.println(mounth);
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("Mounth doesen`t exist");

                    }
                    break;
                }
                case "4": {
                    Month mont = Month.valueOf("SEPTEMBER");
                    for (Month month : months) {
                        if (month.getDays() < mont.getDays()) {
                            mont = month;
                        }

                    }
                    System.out.println(mont);


                    break;
                }

                case "5": {
                    int days = Month.JANUARY.getDays();
                    for (Month m : months) {
                        if (m.getDays() > days) days = m.getDays();
                    }
                    for (Month m : months)
                        if (m.getDays() == days) System.out.println(m.name() + " - Number of days " + days);


                    break;
                }
                case "6": {
                    System.out.println("Enter season");
                    in = new Scanner(System.in);
                    String season = in.next();

                    boolean flag = Season(seassons, season);
                    if (flag) {
                        Seassons s = Seassons.valueOf(season.toUpperCase());
                        int ordinal = s.ordinal();
                        if(ordinal == seassons.length-1){
                            System.out.println(seassons[0]);
                        }else {
                            System.out.println(seassons[ordinal+1]);
                        }

                    }
                    if (!flag) {
                        System.out.println("Doesnt exist");
                    }
                    break;
                }
                case "7": {
                    System.out.println("Enter season");
                    in = new Scanner(System.in);
                    String season = in.next();

                    boolean flag = Season(seassons, season);
                    if (flag) {
                        Seassons s = Seassons.valueOf(season.toUpperCase());
                        int ordinal = s.ordinal();
                        if(ordinal == 0){
                            System.out.println(seassons[seassons.length-1]);
                        }else {
                            System.out.println(seassons[ordinal-1]);
                        }

                    }
                    if (!flag) {
                        System.out.println("Doesnt exist");
                    }
                    break;
                }

                case "8": {
                    System.out.println("Even number");
                    /*in = new Scanner(System.in);
                    String season = in.next();*/
                    for (Month month : months) {
                        if(month.getDays()%2==0){
                            System.out.println(month.name() + " days " + month.getDays() );
                        }

                    }

                    break;
                }
                case "9": {
                    System.out.println("Even number");
                    /*in = new Scanner(System.in);
                    String season = in.next();*/
                    for (Month month : months) {
                        if(month.getDays()%2==1){
                            System.out.println(month.name() + " days " + month.getDays() );
                        }

                    }

                    break;
                }
                case "10":{
                    System.out.println("Enter month");
                    String m = in.next();
                    boolean flag = isMonthPresent(months,m);
                    Month ma = Month.valueOf(m);
                    if(flag){
                        if(ma.getDays()%2==0){
                            System.out.println("Even " + " days " + ma.getDays());
                        }
                        else {
                            System.out.println("Odd " + " days " + ma.getDays());
                        }
                    }
                    break;
                }

            }

        }
    }

    private static boolean isMonthPresent(Month[] months, String month) {
        boolean flag = false;
        for (Month m : months) {
            if (m.name().equalsIgnoreCase(month)) {
                System.out.println("Month exist");
                flag = true;
            }
        }
        return flag;
    }

    private static boolean Season(Seassons[] seassons, String seasson) {
        boolean flag = false;
        for (Seassons m : seassons) {
            if (m.name().equalsIgnoreCase(seasson)) {
                System.out.println("Month exist");
                flag = true;
            }
        }
        return flag;
    }
}
