package Day7;

import java.io.IOException;
import java.util.*;



public class Day7EinsRekursion {
    public static void main(String[] args) throws IOException {

        List < String > list = ReadTxtToArrayList.readLines("Day7/input.txt");

       System.out.println(getNumBags("shiny gold", list).size());
    }


    

    private static List<String> getNumBags(String color, List < String > list) {
        List<String> list2 = new ArrayList<>();
        for (String string: list) {
            if (string.contains(color) && string.indexOf(color) != 0) {
           list2.add(string);
            }

        }
        List < String > allColors = new ArrayList<>();
        if (list2.isEmpty()) {
            return new ArrayList<>();
        }
        else{
            List < String > colors = new ArrayList<>();
            for (String string : list2) {
                if (!allColors.contains(string)) {
                    colors.add(string.substring(0, string.indexOf(" bags")));
                }
            }

            for (String string : colors) {
               allColors.add(string);
               List<String> bags = getNumBags(string, list);
               allColors.addAll(bags);
            }
            List < String > uniqueColors = new ArrayList<>();

            for (String string : allColors) {
                if (!uniqueColors.contains(string)) {
                    uniqueColors.add(string);
                }
            }
            return uniqueColors;
           
        }

    }


}