package Day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Day10
 */
public class Day10 {

    public static void main(String[] args) throws IOException {
        List < Integer > list = ReadTxtToArrayList.readLines("Day10/input.txt");
        List < Integer > jules1 = new ArrayList < > ();
        List < Integer > jules3 = new ArrayList < > ();
        list.add(Collections.max(list) + 3);
        list.add(0);

        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i + 1) == list.get(i) + 1) {
                jules1.add(list.get(i + 1));

            } else if (list.get(i + 1) == list.get(i) + 3) {
                jules3.add(list.get(i + 1));

            } else {
                break;
            }
        }
        System.out.println("Lösung Teil1: " + jules1.size() * jules3.size());



        //Teil2
        List < Long > paths = new ArrayList < > ();

        for (int i = 0; i < Collections.max(list) + 1; i++) {
            paths.add(Long.valueOf(0));
        }
        paths.set(0, Long.valueOf(1));

        for (int i = 1; i < Collections.max(list) + 1; i++) {
            for (int j = 1; j < 4; j++) {
                if (list.contains(i - j)) {
                    paths.set(i, paths.get(i) + paths.get(i - j));
                }
            }
        }
        System.out.println("Lösung Teil2: " + paths.get(paths.size() - 1));


    }
}