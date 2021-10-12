package Day2;

import java.io.*;

import java.util.*;

/**
 * Day2
 */
public class Day2 {

    public static void main(String[] args) throws IOException {
        int antwort = 0;

        List < String > list = ReadTxtToArrayList.readLines("Day2/input.txt");
        String[] test;
        for (String string: list) {
            test = string.split(":");
            test[0] = test[0].replaceAll(" ", "");
            test[1] = test[1].replaceAll(" ", "");
            int counter = 0;


            if (test[0].length() == 4) {
                int zahl1 = Integer.parseInt(String.valueOf(test[0].charAt(0)));
                int zahl2 = Integer.parseInt(String.valueOf(test[0].charAt(2)));
                char suche = test[0].charAt(3);




                for (int i = 0; i < test[1].length(); i++) {
                    if (test[1].charAt(i) == suche) {
                        counter++;

                    }
                }

                if ((counter >= zahl1) && (counter <= zahl2)) {
                    antwort++;
                }

            } else if (test[0].length() == 5) {

                if ((Character.isDigit(test[0].charAt(0))) && (Character.isDigit(test[0].charAt(1)))) {

                    String zwischen = "";
                    zwischen += test[0].charAt(0);
                    zwischen += test[0].charAt(1);
                    int zahl1 = Integer.parseInt(zwischen);
                    int zahl2 = Integer.parseInt(String.valueOf(test[0].charAt(3)));
                    char suche = test[0].charAt(4);



                    for (int i = 0; i < test[1].length(); i++) {
                        if (test[1].charAt(i) == suche) {
                            counter++;

                        }
                    }

                    if ((counter >= zahl1) && (counter <= zahl2)) {
                        antwort++;
                    }

                } else {

                    String zwischen = "";
                    zwischen += test[0].charAt(2);
                    zwischen += test[0].charAt(3);
                    int zahl1 = Integer.parseInt(String.valueOf(test[0].charAt(0)));
                    int zahl2 = Integer.parseInt(zwischen);
                    char suche = test[0].charAt(4);



                    for (int i = 0; i < test[1].length(); i++) {
                        if (test[1].charAt(i) == suche) {
                            counter++;

                        }
                    }

                    if ((counter >= zahl1) && (counter <= zahl2)) {
                        antwort++;
                    }


                }


            } else if (test[0].length() == 6) {

                String zwischen1 = "";
                String zwischen2 = "";
                zwischen1 += test[0].charAt(0);
                zwischen1 += test[0].charAt(1);
                zwischen2 += test[0].charAt(3);
                zwischen2 += test[0].charAt(4);

                int zahl1 = Integer.parseInt(zwischen1);
                int zahl2 = Integer.parseInt(zwischen2);
                char suche = test[0].charAt(5);



                for (int i = 0; i < test[1].length(); i++) {
                    if (test[1].charAt(i) == suche) {
                        counter++;

                    }
                }

                if ((counter >= zahl1) && (counter <= zahl2)) {
                    antwort++;
                }
            }

        }

        System.out.println(antwort);

    }












}