package storyteller;

import java.util.Scanner;
import java.io.File;

public class WordFileReader {
	//a static function called readFile that reads the words into memory.
	private String fileName;
	
	public WordFileReader(String name) {
		fileName = name;
	}
	
	
	public static String setFileName() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("Enter the name of the file: ");
		name = sc.next();
		return name;
	}
	
	
}
