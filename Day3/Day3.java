package Day3;

import java.io.IOException;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        int baumcounter = 0;
        int countervertikal = 0;
        int counterhorizontal = 0;
        List < String > list = ReadTxtToArrayList.readLines("Day3/inputBasti.txt");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 5; j++) {
                list.set(i, list.get(i) + list.get(i));
            }
        }
        while (countervertikal < list.size()) {
            if (list.get(countervertikal).charAt(counterhorizontal) == '#') {
                baumcounter++;
             
            }
            countervertikal++;
            counterhorizontal += 3;
        }
        System.out.println(baumcounter);
    }
}