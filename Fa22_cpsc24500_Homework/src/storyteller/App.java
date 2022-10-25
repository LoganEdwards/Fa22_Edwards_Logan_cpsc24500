package storyteller;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	/* which
	contains the main function and perhaps other functions specific to this application
	that you find useful (like one for printing the welcome message)
	*/
	public static void printHeader() {
		System.out.println("****************************************");
		System.out.println("            STORYTELLER V1.0            ");
		System.out.println("****************************************\n");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fName;
		printHeader();
		System.out.print("Enter the name of the file to read: ");
		fName = sc.next();
		WordFileReader file = new WordFileReader();
		//file.readFile(fName);
		
		
	}
}
