package Day22;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class ReadTxtToArrayList {

	private ReadTxtToArrayList() {

	}



	public static List <Queue<Integer> > readLines(String filename) throws IOException {
		List < Queue<Integer> > list = new ArrayList<>();
		Scanner sc = new Scanner(new File(filename));
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();
        Queue<Integer> player = p1;
        while (sc.hasNext()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                player = p2;
                continue;
            }

            if (!line.contains("P")) {
                player.add(Integer.parseInt(line));
            }
		}
		list.add(p1);
		list.add(p2);
		return list;
	}

	
}