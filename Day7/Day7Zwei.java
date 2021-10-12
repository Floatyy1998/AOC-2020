package Day7;

import java.io.IOException;
import java.util.*;

public class Day7Zwei {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day7/input.txt");

        System.out.println(getBagCount("shiny gold", list) - 1);



    }

    public static int getBagCount(String color, List < String > list) {
        String rule = "";
        for (String string: list) {
            if (string.substring(0, string.indexOf(" bags")).equals(color)) {
                rule = string;
            }
        }

        if (rule.contains("no")) {
            return 1;
        }


        String[] rule2 = rule.substring(rule.indexOf("contain") + 8, rule.length()).split(" ");
        int i = 0;
        int total = 0;

        while (i < rule2.length) {
            int count = Integer.parseInt(rule2[i]);
            String colornew = rule2[i + 1] + " " + rule2[i + 2];
            total += count * getBagCount(colornew, list);
            i += 4;
        }

        return total + 1;
    }
}