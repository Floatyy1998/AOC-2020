package Day25;

/**
 * Day25
 */
public class Day25 {
    public static void main(String[] args) {
        long publicKeyDoor = 15733400;
        long publicKeyCard = 6408062;
        long loop = 0;
        long value = 1;

        while (true) {
            value *= 7;
            value = value % 20201227;
            loop++;
            if (value == publicKeyCard) {
                value = 1;
                for (long j = 0; j < loop; j++) {
                    value *= publicKeyDoor;
                    value %= 20201227;
                }
                break;
            }
        }
        System.out.println("encryption key: " + value);
    }
}