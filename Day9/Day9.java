package Day9;

import java.io.IOException;
import java.util.*;

public class Day9 {
    public static void main(String[] args) throws IOException {
        List < Long > list = ReadTxtToArrayList.readLines("Day9/input.txt");
        int index=0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==25){
            index=i;
            } 
        }

        for (int i = index+1; i < list.size(); i++) {
            if (!hasSum(list, list.get(i),i,i-25)) {
                System.out.println(list.get(i));
            }
        }
   
    }

    private static boolean hasSum(List<Long> list, Long ergebnis, int max, int min) {
        for (int i = min; i < max; i++) {
            for (int j = min+1; j < max; j++) {
                if (list.get(i)+list.get(j)==ergebnis) {
                    return true;
                }
            }
        }


        return false;
    }
}
