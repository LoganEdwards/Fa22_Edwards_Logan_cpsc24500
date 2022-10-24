package storyteller;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class WordFileReader {
	//a static function called readFile that reads the words into memory.	
	//fix use of arrayList later, either split between words and type, or use all together
	public static ArrayList<String> readFile(String fileName) {
		try {
			Scanner fsc = new Scanner(new File(fileName));
			String line;
			String[] tempParts;
			ArrayList<String> parts = new ArrayList<String>();
			//open file and read each line
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				tempParts = line.split(" ");
			}
			
			
			fsc.close();
			return parts;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}	
}
