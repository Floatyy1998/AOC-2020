package Day22;
import java.io.IOException;
import java.util.*;


class Day22 {
    public static void main(String[] args) throws IOException {

        List < Queue < Integer >> list = ReadTxtToArrayList.readLines("Day22/input.txt");
        Queue < Integer > p1 = list.get(0);
        Queue < Integer > p2 = list.get(1);


        System.out.println("Part1: " + part1(new LinkedList <> (p1), new LinkedList <> (p2)));

        System.out.println("Part2: " + part2(p1, p2));
    }


    public static boolean seenBefore(Set < List < Queue < Integer >>> seen,
        Queue < Integer > p1, Queue < Integer > p2) {
        List < Queue < Integer >> l = new ArrayList < > ();
        l.add(p1);
        l.add(p2);
        boolean result = seen.contains(l);
        seen.add(l);
        return result;
    }


    public static long part2(Queue < Integer > p1, Queue < Integer > p2) {
        Queue < Integer > winner = newGame(p1, p2) ? p1 : p2;
        long part2 = 0;
        long cardValue = winner.size();
        for (int e: winner) {
            part2 += e * cardValue;
            --cardValue;
        }
        return part2;
    }


    public static boolean newGame(Queue < Integer > p1, Queue < Integer > p2) {
        Set < List < Queue < Integer >>> uniqueHands = new HashSet < > ();

        while (!p1.isEmpty() && !p2.isEmpty()) {
            if (seenBefore(uniqueHands, p1, p2)) return true;
            boolean p1Wins = true;
            int p1Card = p1.remove();
            int p2Card = p2.remove();
            if (p1.size() < p1Card || p2.size() < p2Card) {
                p1Wins = p1Card > p2Card;
            } else {
                Queue < Integer > p1NewDeck = new LinkedList < > ();
                Queue < Integer > p2NewDeck = new LinkedList < > ();
                int i = p1Card;
                for (int e: new LinkedList < Integer > (p1)) {
                    if (i <= 0) break;
                    p1NewDeck.add(e);
                    --i;
                }
                i = p2Card;
                for (int e: new LinkedList < Integer > (p2)) {
                    if (i <= 0) break;
                    p2NewDeck.add(e);
                    --i;
                }
                p1Wins = newGame(p1NewDeck, p2NewDeck);
            }

            if (p1Wins) {
                p1.add(p1Card);
                p1.add(p2Card);
            } else {
                p2.add(p2Card);
                p2.add(p1Card);
            }
        }
        return p2.isEmpty();
    }


    public static long part1(Queue < Integer > p1, Queue < Integer > p2) {
        while (!p1.isEmpty() && !p2.isEmpty()) {
            boolean p1Wins = p1.peek() > p2.peek();
            if (p1Wins) {
                p1.add(p1.remove());
                p1.add(p2.remove());
            } else {
                p2.add(p2.remove());
                p2.add(p1.remove());
            }
        }

        Queue < Integer > winner = p2.isEmpty() ? p1 : p2;
        long part1 = 0;
        long cardValue = winner.size();
        for (int e: winner) {
            part1 += e * cardValue;
            --cardValue;
        }
        return part1;
    }

}