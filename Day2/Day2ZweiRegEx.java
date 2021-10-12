package Day2;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class Day2ZweiRegEx {
    public static void main(String[] args) throws IOException {
        int antwort = 0;
        List < String > list = ReadTxtToArrayList.readLines("Day2/input.txt");
        String pattern = "([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)";
        Pattern r = Pattern.compile(pattern);

        for (String string: list) {


            Matcher m = r.matcher(string);
            if (m.find()) {
                int min = Integer.parseInt(m.group(1));
                int max = Integer.parseInt(m.group(2));
                char buchstabe = m.group(3).charAt(0);
                String password = m.group(4);


                if (password.charAt(min - 1) == buchstabe ^ password.charAt(max - 1) == buchstabe) {
                    antwort++;
                }


            } else System.out.println("FUCK");

        }
        System.out.println(antwort);
    }




}