package Day1;

import java.io.*;
import java.util.*;

public class ReadTxtToArray {
    private ReadTxtToArray() {

    }

    public static List < Integer > readLines(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        List < String > list = new ArrayList < > ();
        ArrayList < Integer > listInt = new ArrayList < > ();

        while ((line = in .readLine()) != null) {
            list.add(line);
        } in .close();

        String[] lines = (String[]) list.toArray(new String[0]);

        for (String s: lines) {
            listInt.add(Integer.parseInt(s));
        }
        return listInt;
    }
}