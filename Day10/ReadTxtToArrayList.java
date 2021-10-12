package Day10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ReadTxtToArrayList {

	private ReadTxtToArrayList() {

	}



	public static List < Integer > readLines(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		List < Integer > list = new ArrayList < > ();


		while ((line = in .readLine()) != null) {
			list.add(Integer.parseInt( line.trim()));
		} in .close();


		return list;
	}
}