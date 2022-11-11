package menagerie;

import java.util.ArrayList;
import java.util.Scanner;

public class MenagerieTestFile {

	public static void printOptions() {
		//print option menu
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.\n2. Print list of pets.");
		System.out.println("3. Save pets to a file.\n4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.\n7. Exit");
		System.out.print("Enter the number of your choice: ");
	}
	
	public static void newPetType() {
		System.out.print("Enter d for dog, c for cat, or f for fish: ");
	}
	public static void newPetInfo() {
		System.out.print("Enter name, age, and weight: ");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int curChoice;
		String tempAnimalType = "";
		//Header
		System.out.println("*************************************************");
		System.out.println("       Menagerie V1.0: The Pet Simulator             ");
		System.out.println("*************************************************");
		
		//Arr list to hold all of the pets that are created by the user
		ArrayList<Pet> animals = new ArrayList<Pet>();
		FileMaker fm = new FileMaker();
		printOptions();
		curChoice = scan.nextInt();
		while (curChoice != 7) {
			if (curChoice == 1) {
				//add a new pet
				newPetType();
				tempAnimalType = scan.next();
				newPetInfo();
				//check for d, c, or f and create that type of animal
				if (tempAnimalType.equalsIgnoreCase("d")) {
					animals.add(new Dog(scan.next(), scan.nextInt(), scan.nextDouble()));
				}
				else if (tempAnimalType.equalsIgnoreCase("c")) {
					animals.add(new Cat(scan.next(), scan.nextInt(), scan.nextDouble()));
				}
				if (tempAnimalType.equalsIgnoreCase("f")) {
					animals.add(new Fish(scan.next(), scan.nextInt(), scan.nextDouble()));
				}				
			}
			
			else if (curChoice == 2) {
				//add a blank line then print each pet using their toString()
				System.out.println();
				for (Pet p : animals) {
					System.out.println(p.toString());
				}
			}
			
			else if(curChoice == 3) {
				fm.writeToFile(animals, "MenagerieTEST");
			}
			
			else if(curChoice == 4) {
				
			}
			
			else if(curChoice == 5) {
				
			}
			
			else if(curChoice == 6) {
				
			}
		printOptions();
		curChoice =scan.nextInt();
		}
		
		
	}
}
