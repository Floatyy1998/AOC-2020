package Day9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ReadTxtToArrayList {

	private ReadTxtToArrayList() {

	}



	public static List < Long > readLines(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		List < Long > list = new ArrayList < > ();


		while ((line = in .readLine()) != null) {
			list.add(Long.parseLong( line.trim()));
		} in .close();


		return list;
	}
}