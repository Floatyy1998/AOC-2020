package Day7;

import java.io.IOException;
import java.util.*;



public class Day7 {
    public static void main(String[] args) throws IOException {

        int leercounter = 0;
        String temp = "";
        List < String > list = ReadTxtToArrayList.readLines("Day7/input.txt");
        Set <String> set = new HashSet<>();
        set.add("shiny gold");

        for (int x = 0; x < 5; x++) {
            for (String string: list) {
                if (containsItemOfSet(string, set.toArray(String[]::new))) {
                  
                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) == ' ') {
                            temp += string.charAt(i);
                            leercounter++;
                        } else {
                            temp += string.charAt(i);
                        }
    
                        if (leercounter == 2) {
                            break;
                        }
                    }
                        set.add(temp.trim());
                    
                    temp = "";
                    leercounter = 0;
    
                }
            }
        }
        System.out.println(set.size()-1);
    }
    private static boolean containsItemOfSet(String string, String[] set) {

        for (int i = 0; i < set.length; i++) {
            if (string.contains(set[i])) {
                return true;
            }
        }
        return false;
    }
}