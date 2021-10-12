package Day5;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Day5
 */
public class Day5 {

    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day5/inputBasti.txt");
        List < Integer > seatID = new ArrayList < > ();
        Set < Integer > set2;
        int row = 0;
        int column = 0;

        for (String string: list) {
            row = Integer.parseInt(string.substring(0, 7).replace('F', '0').replace('B', '1'), 2);
            column = Integer.parseInt(string.substring(7, string.length()).replace('L', '0').replace('R', '1'), 2);
            
            seatID.add(row * 8 + column);
        }

        //Teil1
        System.out.println(Collections.max(seatID));

        //Teil2
        Collections.sort(seatID);
        Set < Integer > set1 = new HashSet < > (seatID);
        set2 = IntStream.range(seatID.get(0), seatID.get(seatID.size() - 1)).boxed().collect(Collectors.toSet());
        set2.removeAll(set1);
        System.out.println(set2);
    }
}