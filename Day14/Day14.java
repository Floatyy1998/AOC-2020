package Day14;

import java.io.IOException;
import java.util.*;

public class Day14 {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day14/input.txt");
        String mask = "";
        Map < Integer, Long > memory = new HashMap < > ();
        for (int i = 0; i < list.size(); i++) {

            String[] inp = list.get(i).split(" = ");
            if (inp[0].equals("mask")) {
                mask = inp[1];
            } else {
                int addr = Integer.parseInt(inp[0].substring(4, inp[0].length() - 1));
                int value = Integer.parseInt(inp[1]);
                memory.put(addr, maskValue(mask, value));
            }

        }
        long sum = 0;
        for (Long i: memory.values()) {
            sum += i;
        }
        System.out.println(sum);

    }

    private static long maskValue(String mask, int value) {

        String binaryValue = new StringBuilder(Integer.toBinaryString(value)).reverse().toString();
        mask = new StringBuilder(mask).reverse().toString();
        String newValue = "";
        while (binaryValue.length() != mask.length()) {
            binaryValue += "0";

        }

        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '0' || mask.charAt(i) == '1') {
                newValue += mask.charAt(i);

            } else {
                newValue += binaryValue.charAt(i);
            }

        }

        return Long.parseLong(new StringBuilder(newValue).reverse().toString(), 2);
    }


}