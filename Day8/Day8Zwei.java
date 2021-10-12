package Day8;

import java.io.*;
import java.util.List;
import java.util.regex.*;
//217!!!!
public class Day8Zwei {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day8/input.txt");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, 3).equals("jmp")) {
                if (getAcc( i, "nop") > -1) {
                    System.out.println(getAcc( i, "nop"));
                    break;
                }

            } else if (list.get(i).substring(0, 3).equals("nop")) {
                if (getAcc( i, "jmp") > -1) {
                    System.out.println(getAcc( i, "jmp"));
                    break;
                }

            }

        }

    }

    public static int getAcc( int x, String change) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day8/input.txt");
        int i = 0;
        int acc = 0;
        list.set(x, change + list.get(i).substring(3, list.get(i).length()));

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
                return -1;

            }
        }

        return acc;


    }
}