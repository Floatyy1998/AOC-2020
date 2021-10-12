package Day8;

import java.io.*;
import java.util.List;
import java.util.regex.*;

public class Day8 {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day8/input.txt");
        int i = 0;
        int acc = 0;

        String pattern = "([a-z]{3}) ([-,+])([0-9]+)";
        Pattern r = Pattern.compile(pattern);

        while (i < list.size()) {
            Matcher m = r.matcher(list.get(i));
            if (m.find()) {
                if (m.group(1).equals("acc")) {
                    if (m.group(2).equals("-")) {
                        acc -= Integer.parseInt(m.group(3));
                    } else {
                        acc += Integer.parseInt(m.group(3));
                    }
                    list.set(i, "");
                    i++;
                } else if (m.group(1).equals("jmp")) {
                    if (m.group(2).equals("-")) {
                        list.set(i, "");
                        i -= Integer.parseInt(m.group(3));
                    } else {
                        list.set(i, "");
                        i += Integer.parseInt(m.group(3));
                    }
                } else {
                    i++;
                }




            } else {
                break;
            }
        }
        System.out.println(acc);


    }
}