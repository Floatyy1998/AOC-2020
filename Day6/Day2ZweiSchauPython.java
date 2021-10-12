package Day6;

import java.io.IOException;
import java.util.*;

public class Day2ZweiSchauPython {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayListZwei.readLines("Day6/input.txt");
        List < String[] > list2 = new ArrayList < > ();
        List < Object[] > list3 = new ArrayList < > ();


        for (String strings: list) {
            String[] s = strings.split(" ");
            for (int i = 0; i < s.length; i++) {
                list2.add(s[i].split(""));
            }
            Object[]test = list2.toArray();
            
 
           list3.add(test);
        }

       for (Object[] objects : list3) {
            
        

        for (int i = 1; i < objects.length; i++) 
        {
      System.out.println(objects[i].toString());
             
       
        }

       

       }


      

    

    }

}