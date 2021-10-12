package Day16;

import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class Day16 {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day16/input.txt");
        List < Integer > valids = new ArrayList < > ();
        Set < Integer > allValids = new HashSet < > ();
        String pattern = "[a-z]*( [a-z]*)?: ([0-9]*)-([0-9]*) or ([0-9]*)-([0-9]*)";
        Pattern r = Pattern.compile(pattern);

        for (int i = 0; i < list.size(); i++) {
            Matcher m = r.matcher(list.get(i));
            if (m.find()) {
                valids.add(Integer.parseInt(m.group(2)));
                valids.add(Integer.parseInt(m.group(3)));
                valids.add(Integer.parseInt(m.group(4)));
                valids.add(Integer.parseInt(m.group(5)));
            }
        }
        for (int i = 0; i < valids.size() - 1; i++) {
            for (int j = valids.get(i); j < valids.get(i + 1); j++) {
                allValids.add(j);
            }

        }
        boolean iwas =true;
        String temp ="";
        while (iwas) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("nearby tickets:")) {
                    for (int j = i+1; j < list.size(); j++) {
                        temp+=list.get(j)+",";
                    }
                    iwas= false;
                    break;
                }
            }
            
        }
        String[] test = temp.split(",");
        int counter=0;
        for (String string : test) {
           if (!allValids.contains(Integer.parseInt(string))) {
               counter+=Integer.parseInt(string);
           }
        }
        System.out.println(counter);
    }


}