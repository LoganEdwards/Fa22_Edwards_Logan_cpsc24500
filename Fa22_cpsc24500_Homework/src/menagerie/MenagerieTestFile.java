package menagerie;

import java.util.Scanner;

public class MenagerieTestFile {

	public static int printOptions(Scanner sc) {
		//print option menu
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.\n2. Print list of pets.");
		System.out.println("3. Save pets to a file.\n4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.\n7. Exit");
		System.out.print("Enter the number of your choice: ");
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		//Header
		System.out.println("*************************************************");
		System.out.println("       Menagerie V1.0: The Pet Simulator             ");
		System.out.println("*************************************************");
		
		
	
	
	
	}
}
