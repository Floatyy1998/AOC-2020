package Day12;

import java.io.IOException;

import java.util.*;

public class Day12 {
    
    public static void main(String[] args)throws IOException {
        List<String> list = ReadTxtToArrayList.readLines("Day12/input");
        int[] pos = {0,0};
        int currentRotation = 0;
        Map<Integer, Character> rotation = new HashMap<>();
        rotation.put(0, 'E');
        rotation.put(90, 'S');
        rotation.put(180, 'W');
        rotation.put(270, 'N');
     
        for (String string : list) {
            char c =string.charAt(0);
          
            char orientation = rotation.get(currentRotation);

            if (c=='F') {
                c = orientation;
            }

            if (c=='N') {
                pos[1] += Integer.parseInt(string.substring(1,string.length()));
            }
            else if (c=='S') {
                pos[1] -= Integer.parseInt(string.substring(1,string.length()));
            }
            else if (c=='E') {
                pos[0] += Integer.parseInt(string.substring(1,string.length()));
            }
            else if (c=='W') {
                pos[0] -= Integer.parseInt(string.substring(1,string.length()));
            }
            else if (c=='R') {
                currentRotation = (currentRotation + Integer.parseInt(string.substring(1,string.length() ) ) ) % 360;
           
            }
            else if (c=='L') {
                currentRotation = (currentRotation - Integer.parseInt(string.substring(1,string.length())));
              if (currentRotation<0) {
                   currentRotation =(360+currentRotation)%360;
              }
            
            }
        }
        System.out.println(Math.abs(pos[0])+Math.abs(pos[1]));
    }

}
