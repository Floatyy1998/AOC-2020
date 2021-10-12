package Day24;

import java.io.File;

import java.util.*;

public class Day24 {
    private static ArrayList<String> input;
    private static boolean[][] floor;

    public static void main(String[] args) {
        Scanner reader = null;
        try {
            reader = new Scanner(new File("Day24/input.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
        }

        input = new ArrayList<>();

        while (reader.hasNext()) {
            input.add(reader.nextLine());
        }

        part1();
        part2();
    }

    public static void part1() {
        // We can use parts of a 2D boolean array to represent a hexagonal tile floor.
        // We will alternate between using even and odd indices on each row.
        // For example:
        // □x□x□x□x□x□x□x□
        // x□x□x□x□x□x□x□x
        // □x□x□x□x□x□x□x□
        // x□x□x□x□x□x□x□x
        // □x□x□x□x□x□x□x□
        // x□x□x□x□x□x□x□x
        // The coordinates marked with an 'x' will be ignored.
        // Every cell [r, c] will have 6 neighbors (ie [r-1, c-1], [r-1, c+1], [r, c-2],
        // [r, c+2], [r+1, c-1], [r+1, c+1]).
        floor = new boolean[500][500];

        // This will be the center of our floor and the reference tile we use to
        // initialize all other tiles
        int midX = floor.length / 2;
        int midY = floor[0].length / 2;

        for (String in : input) {
            String coords = getCoordinates(in);
            int x = Integer.parseInt(coords.split(",")[0]);
            int y = Integer.parseInt(coords.split(",")[1]);
            // x and y shifts should be applied to the reference tile to flip the boolean
            floor[midY + y][midX + x] = !floor[midY + y][midX + x];
        }

        int count = 0;
        // We don't have to worry about skipping our unused cells in the following loop
        // as they will always be false anyway.
        for (int r = 0; r < floor.length; r++) {
            for (int c = 0; c < floor[0].length; c++) {
                if (floor[r][c])
                    count++;
            }
        }

        System.out.println("Black Tiles in initial state: " + count);
    }

    public static void part2() {
        for (int day = 1; day <= 100; day++) {
            floor = updateFloor();
        }
        int count = 0;
        for (int r = 0; r < floor.length; r++) {
            for (int c = 0; c < floor[0].length; c++) {
                if (floor[r][c]) {
                    count++;
                }
            }
        }
        System.out.println("Black Tiles after 100 days: " + count);
    }

    /**
     * 
     * Any black tile with zero or more than 2 black tiles immediately adjacent to
     * it is flipped to white. Any white tile with exactly 2 black tiles immediately
     * adjacent to it is flipped to black.
     * 
     * @return The 2D array of boolean representing the floor in it's updated state.
     */
    private static boolean[][] updateFloor() {
        // make a copy of the current floor state
        boolean[][] copy = new boolean[floor.length][floor[0].length];
        for (int r = 0; r < copy.length; r++) {
            for (int c = 0; c < copy[0].length; c++) {
                copy[r][c] = floor[r][c];
            }
        }
        // In order to avoid out-of-bounds errors, I will only traverse
        // the "inside" of the 2D array.
        // I will only loop from the 2nd row to the 2nd to last row and
        // from the 3rd or 4th column (depending on what row I'm on) to the 3rd to last
        // column incrementing by 2.
        for (int r = 1; r <= floor.length - 2; r += 1) {
            // I use a ternary to decide whether c should start at index 2 or 3.
            for (int c = (r % 2 == 0) ? 2 : 3; c <= floor[0].length - 3; c += 2) {
                // count the surrounding neighbors that are 'true'
                int count = 0;
                if (floor[r - 1][c - 1])
                    count++;
                if (floor[r - 1][c + 1])
                    count++;
                if (floor[r][c - 2])
                    count++;
                if (floor[r][c + 2])
                    count++;
                if (floor[r + 1][c - 1])
                    count++;
                if (floor[r + 1][c + 1])
                    count++;

                if (floor[r][c] && (count == 0 || count > 2))
                    copy[r][c] = false;

                if (!floor[r][c] && count == 2)
                    copy[r][c] = true;

            }
        }

        // This copy will overwrite the original floor array when returned
        return copy;
    }

    /**
     * Given a String with directions (e, w, ne, nw, se, sw), we will produce the
     * (x, y) coordinates of the tile at the end of the path
     * 
     * <pre>
     * For example: given "seenw", we will reduce this to 
     * individual directions : se, e, nw 
     * If we start at (0, 0), we will first go to (2, 1), 
     * then to (4, 1), and finally to (2, 0).
     * Note: 's' is a positive change in y and 'n' is a negative change in y
     * as these represent changes in a 2D array. Also, 'e' and 'w' will change x by +/-2 
     * because we are only using every other cell in the 2D array 
     * in order for it to represent hexagonal tiles.
     * </pre>
     * 
     * @param in String representation of the path taken from a reference tile to
     *           the tile that should be flipped
     * @return A string representation of the coordinates of the tile to be flipped.
     */
    private static String getCoordinates(String in) {
        int i = 0;
        String dir = "";
        int x = 0;
        int y = 0;
        while (i < in.length()) {
            // A little regex bc why not.
            // If the substring matches either 'e' or 'w', that is our direction.
            // Otherwise, it is an 'n' or 's' and we should grab two characters.
            if (in.substring(i, i + 1).matches("[ew]")) {
                dir = (in.substring(i, i + 1));
                i++;
            } else {
                dir = (in.substring(i, i + 2));
                i += 2;
            }

            if (dir.equals("e")) {
                x += 2;
            } else if (dir.equals("w")) {
                x -= 2;
            } else if (dir.equals("ne")) {
                y -= 1;
                x += 1;
            } else if (dir.equals("nw")) {
                y -= 1;
                x -= 1;
            } else if (dir.equals("se")) {
                y += 1;
                x += 1;
            } else if (dir.equals("sw")) {
                y += 1;
                x -= 1;
            }

        }

        // This string will be split apart after it is returned
        // for it's individual parts
        return x + "," + y;
    }

}
// 495, 4012