package Day2;

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
			list.add(line);
		} in .close();


		return list;
	}
}