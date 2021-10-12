package Day12;

import java.io.IOException;
import java.util.*;



/**
 * Day12Zwei
 */
public class Day12Zwei {

    public static void main(String[] args)throws IOException {
        List<String> list = ReadTxtToArrayList.readLines("Day12/input");
        Integer[] waypoint = {1,10,0,0};
        int[] pos = {0,0};
        

        for (String string : list) {
            char c =string.charAt(0);
            int amount = Integer.parseInt(string.substring(1,string.length()));

            if (c=='F') {
                pos[0] += amount*(waypoint[1]-waypoint[3]);
                pos[1] += amount*(waypoint[0]-waypoint[2]);
            }

            else if (c=='N') {
                waypoint[0]+=amount;
            }
            else if (c=='S') {
                waypoint[2]+=amount;
            }
            else if (c=='E') {
                waypoint[1]+=amount;
            }
            else if (c=='W') {
                waypoint[3]+=amount;
            }
            else if (c=='R') {
               amount = amount/90;
               Collections.rotate(Arrays.asList(waypoint), amount);
               
           
            }
            else if (c=='L') {
                amount = amount/90;
               
                Collections.rotate(Arrays.asList(waypoint), -amount);
            }
        }

        System.out.println((Math.abs(pos[0]) + Math.abs(pos[1])));
    }
}