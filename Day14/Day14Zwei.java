package Day14;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14Zwei {
    public static void main(String[] args) throws IOException {
        List < String > list = ReadTxtToArrayList.readLines("Day14/input.txt");
        String[] mask = null;
        Map < BigInteger, Integer > memory = new HashMap < > ();
        for (int i = 0; i < list.size(); i++) {

            String[] inp = list.get(i).split(" = ");
            if (inp[0].equals("mask")) {
                mask = inp[1].split("");
            } else {
                int addr = Integer.parseInt(inp[0].substring(4, inp[0].length() - 1));
                String[] binaryAddress = String.format("%36s", Integer.toBinaryString(addr)).replace(" ", "0").split("");
                Set < String[] > addresses = applyPt2Mask(mask, binaryAddress);
                addresses.stream()
                    .map(sa -> String.join("", sa))
                    .map(binStr -> new BigInteger(binStr, 2))
                    .forEach(adr -> memory.put(adr, Integer.valueOf(inp[1])));
            }

        }

        BigInteger sum = memory.values().stream().map(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println("Part 2: " + sum);

    }

    private static Set < String[] > applyPt2Mask(String[] mask, String[] binaryAddress) {
        List < Integer > xIndexes = new ArrayList < > ();
        for (int i = 0; i < mask.length; i++) {
            switch (mask[i].toUpperCase()) {
                case "X":
                    xIndexes.add(i);
                case "1":                           
                    binaryAddress[i] = mask[i];
                    break;
                case "0":
                    break;
                default:
                    throw new RuntimeException("something went wrong");
            }
        }

        Set < String[] > permutations = new HashSet < > ();
        permutations.add(binaryAddress);
        for (int index: xIndexes) {

            permutations = permutations.stream()
                .flatMap(a -> {

                    String[] scenario0 = Arrays.stream(a).toArray(String[]::new);
                    scenario0[index] = "0";
                    String[] scenario1 = a;
                    scenario1[index] = "1";
                    return Stream.of(scenario0, scenario1);
                })
                .collect(Collectors.toSet());
        }
        return new HashSet < > (permutations);
    }


}