package Day4;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    public static void main(String[] args) throws IOException {
        int antwort = 0;
        List < String > list = ReadTxtToArrayList.readLines("Day4/input.txt");
        String pattern = "([a-z]+:.*\s?){7}";
        Pattern r = Pattern.compile(pattern);
        


        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replaceAll("\\n", " ").trim());
            list.set(i, list.get(i).replaceAll("cid:[0-9]+", "").trim());
            list.set(i, list.get(i).replaceAll("  ", " ").trim());
        }

        for (String string: list) {
            Matcher m = r.matcher(string);
            if (m.find()) {

                antwort++;
            }
        }

        System.out.println(antwort);

    }
}