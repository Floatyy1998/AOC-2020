package Day9;

import java.io.IOException;
import java.util.*;


public class Day9Zwei {
    public static void main(String[] args) throws IOException {

        List < Long > list = ReadTxtToArrayList.readLines("Day9/input.txt");
        long ergebnis = 1038347917;
        int index = 646;
        
        for (int i = 0; i < index; i++) {
            long sum = list.get(i);
            long smallest = list.get(i);
            long largest = list.get(i);

            for (int j = 1; i+j < index;j++) {
                sum+= list.get(i+j);
                if (list.get(i+j)<smallest) {smallest=list.get(i+j);}
                if (list.get(i+j)>largest) {largest=list.get(i+j);}
                if (sum==ergebnis) {
                    System.out.println(largest+smallest);
                }
                if (sum>ergebnis) {
                    break;
                }
                
            }
        }
    }
}