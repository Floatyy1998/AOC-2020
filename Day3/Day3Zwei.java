package Day3;

import java.io.IOException;
import java.util.*;

public class Day3Zwei {
    public static void main(String[] args) throws IOException {
        int baumcounter1 = 0;
        int baumcounter2 = 0;
        int baumcounter3 = 0;
        int baumcounter4 = 0;
        int baumcounter5 = 0;
  
        long antwort = 0;
        List < String > list = ReadTxtToArrayList.readLines("Day3/inputBasti.txt");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 7; j++) {
                list.set(i, list.get(i) + list.get(i));
            }
        }
        for (int i = 0; i < 5; i++) {
         
            int countervertikal = 0;
            int counterhorizontal = 0;
            switch (i) {
                case 0:
                    while (countervertikal < list.size()) {
                        if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                            baumcounter1++;
                            countervertikal++;
                            counterhorizontal += 1;
                        } else {
                            countervertikal++;
                            counterhorizontal += 1;
                        }
                    }
                    break;
                case 1:
                    while (countervertikal < list.size()) {
                        if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                            baumcounter2++;
                            countervertikal++;
                            counterhorizontal += 3;
                        } else {
                            countervertikal++;
                            counterhorizontal += 3;
                        }
                    }
                    break;
                case 2:
                    while (countervertikal < list.size()) {
                        if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                            baumcounter3++;
                            countervertikal++;
                            counterhorizontal += 5;
                        } else {
                            countervertikal++;
                            counterhorizontal += 5;
                        }
                    }
                    break;
                case 3:
                    while (countervertikal < list.size()) {
                        if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                            baumcounter4++;
                            countervertikal++;
                            counterhorizontal += 7;
                        } else {
                            countervertikal++;
                            counterhorizontal += 7;
                        }
                    }
                    break;
                case 4:
                    while (countervertikal < list.size()) {
                        if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                            baumcounter5++;
                            countervertikal += 2;
                            counterhorizontal += 1;
                        } else {
                            countervertikal += 2;
                            counterhorizontal += 1;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(baumcounter1);
        System.out.println(baumcounter2);
        System.out.println(baumcounter3);
        System.out.println(baumcounter4);
        System.out.println(baumcounter5);

        antwort = baumcounter1 * baumcounter2 * baumcounter3 * baumcounter4 * (long) baumcounter5;
        System.out.println(antwort);
    }
}