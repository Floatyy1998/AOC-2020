package Day6;

import java.io.IOException;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day6/input.txt");
        Set < String > set = new HashSet < > ();
        int antwort = 0;
        System.out.println(list);

        for (String string: list) {
            for (int i = 0; i < string.length(); i++) {
                set.add(String.valueOf(string.charAt(i)));
            }
            System.out.println(set);
            antwort += set.size();
            set.clear();
        }
        System.out.println(antwort);


    }
}