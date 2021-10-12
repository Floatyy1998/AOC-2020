package Day1;

import java.io.*;


import java.util.List;



public class Day1 {
    public static void main(String[] args) throws IOException {
        List < Integer > test = ReadTxtToArray.readLines("Day1/d.txt");
        for (int i = 0; i < test.size(); i++) {
            for (int j = i + 1; j < test.size(); j++) {
                // compare list.get(i) and list.get(j)
                int vergleich = test.get(i) + test.get(j);
                if (vergleich == 2020) {
                    System.out.println(test.get(i));
                    System.out.println(test.get(j));
                    System.out.println(test.get(i) * test.get(j));
                }
            }
        }


    }





}