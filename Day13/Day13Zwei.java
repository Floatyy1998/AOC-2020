package Day13;

import java.io.IOException;


import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Day13Zwei
 */
public class Day13Zwei {

    public static void main(String[] args) throws IOException {

        String[] s = ReadTxtToArrayList.readLinesArray("Day13/inputJan.txt")[1].split(",");



        long[][] nums = range(0, s.length).filter(i -> !s[i].equals("x"))
            .mapToObj(i -> new long[] {
                parseLong(s[i]), i
            })
            .toArray(long[][]::new);

        long product = stream(nums).mapToLong(a -> a[0]).reduce((a, b) -> a * b).getAsLong();
        long sum = stream(nums).mapToLong(a -> a[1] * (product / a[0]) * inverseModulo(product / a[0], a[0])).sum();
        System.out.println(product - sum % product);
    }

    public static long inverseModulo(long x, long y) {
        if (x != 0) {
            long modulo = y % x;
            return modulo == 0 ? 1 : y - inverseModulo(modulo, x) * y / x;
        }
        return 0;
    }

}