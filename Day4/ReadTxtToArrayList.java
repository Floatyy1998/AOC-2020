package Day4;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;




public class ReadTxtToArrayList {

	private ReadTxtToArrayList() {

	}



	public static List < String > readLines(String filename) throws IOException {
		Scanner read = new Scanner(new File(filename));
		read.useDelimiter(Pattern.compile("^\s*$", Pattern.MULTILINE));
		List < String > list = new ArrayList < > ();
		String liebe;

		while (read.hasNext()) {
			liebe= read.next();
			list.add(liebe);
			
		}
		read.close();


		return list;
	}
}