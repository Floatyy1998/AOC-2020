package Day11;

import java.io.IOException;
import java.util.*;

public class Day11 {
    public static void main(String[] args) throws IOException {
        List < String > seats = ReadTxtToArrayList.readLines("Day11/input.txt");
        

        System.out.println(countSeated(simulate(seats,5,true)));
    }

    public static List < String > simulate(List < String > seat, int tolerance, boolean inSight) {
        List < String > seats = new ArrayList < > (seat);
        List < String > previous = new ArrayList < > ();

        while (!previous.equals(seats)) {
            int neighbors;
            previous = new ArrayList < > (seats);
            seats.clear();
            for (int row_id = 0; row_id < previous.size(); row_id++) {
                String new_row = "";
                for (int col_id = 0; col_id < previous.get(row_id).length(); col_id++) {
                    if (!inSight) {
                        neighbors = count_adjacent_seats(row_id, col_id, previous);
                    } else {
                        neighbors = count_seeable_Seats(row_id, col_id, previous);
                    }

                    if (previous.get(row_id).charAt(col_id) == '.') {
                        new_row += '.';
                    } else if (previous.get(row_id).charAt(col_id) == 'L') {
                        if (neighbors == 0) {
                            new_row += '#';
                        } else {
                            new_row += 'L';
                        }

                    } else if (previous.get(row_id).charAt(col_id) == '#') {
                        if (neighbors >= tolerance) {
                            new_row += 'L';

                        } else {
                            new_row += '#';
                        }
                    } else {
                        new_row += previous.get(row_id).charAt(col_id);
                    }

                }
                seats.add(new_row);
            }
        }

        return previous;
    }

    private static int count_seeable_Seats(int row_id, int col_id, List < String > seats) {
        int counter = 0;
        List < int[] > adjacent = new ArrayList < > ();
        int[] a = {-1,-1}, b = {-1,0}, c = {-1,1}, d = {0,-1}, e = {0,1}, f = {1,-1}, g = {1,0}, h = {1,1};
        adjacent.add(a);
        adjacent.add(b);
        adjacent.add(c);
        adjacent.add(d);
        adjacent.add(e);
        adjacent.add(f);
        adjacent.add(g);
        adjacent.add(h);

        for (int[] i: adjacent) {
            int rowIdx = row_id + i[0];
            int colIdx = col_id + i[1];
            try {
                while (rowIdx<seats.size() && colIdx<seats.size())  {
                if (seats.get(rowIdx).charAt(colIdx)=='#') {
                    counter++;
                    break;
                }
                if (seats.get(rowIdx).charAt(colIdx)=='L') {
                   break;
                }
                rowIdx+=i[0];
                colIdx+=i[1];
            } 
            } catch (Exception ex) {
                //TODO: handle exception
            }
        }
        return counter;
    }

    private static int count_adjacent_seats(int row_id, int col_id, List < String > seats) {
        int counter = 0;
        List < int[] > adjacent = new ArrayList < > ();
        int[] a = {-1,-1}, b = {-1,0}, c = {-1,1}, d = {0,-1}, e = {0,1}, f = {1,-1}, g = {1,0}, h = {1,1};
        adjacent.add(a);
        adjacent.add(b);
        adjacent.add(c);
        adjacent.add(d);
        adjacent.add(e);
        adjacent.add(f);
        adjacent.add(g);
        adjacent.add(h);

        for (int[] i: adjacent) {
            try {
                if (seats.get(row_id + i[0]).charAt(col_id + i[1]) == '#') {
                    counter++;
                }
            } catch (Exception ex) {

            }
        }
        return counter;
    }

    public static int countSeated(List < String > seats) {
        int counter = 0;
        for (int i = 0; i < seats.size(); i++) {
            for (int j = 0; j < seats.get(i).length(); j++) {
                if (seats.get(i).charAt(j) == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

}