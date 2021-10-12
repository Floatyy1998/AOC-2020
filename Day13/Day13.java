package Day13;

import java.io.IOException;
import java.util.*;


public class Day13 {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day13/input.txt");
        List < Integer > time = new ArrayList < > ();
        Map < Integer, Integer > time_map = new HashMap < > ();


        String[] s = list.get(1).replaceAll("[,x]+", ",").split(",");

        for (String string: s) {
            int wait = (Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(0)) % Integer.parseInt(string)) + Integer.parseInt(string)) - Integer.parseInt(list.get(0));
            time_map.put(wait, Integer.parseInt(string));
            time.add(wait);
        }
        System.out.println(time_map.get(Collections.min(time)) * Collections.min(time));
    }
}