package Day13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ReadTxtToArrayList {

	private ReadTxtToArrayList() {

	}



	public static List < String > readLines(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		List < String > list = new ArrayList < > ();


		while ((line = in .readLine()) != null) {
			list.add(line.trim());
		} in .close();


		return list;
	}

	public static String[] readLinesArray(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		List < String > list = new ArrayList < > ();
		

		while ((line = in .readLine()) != null) {
			list.add(line.trim());
		} in .close();
		String[] lines= new String[list.size()];

		int i =0;
		for (String string : list) {
			lines[i] = string;
			i++;
		}
		return lines;
	}
}