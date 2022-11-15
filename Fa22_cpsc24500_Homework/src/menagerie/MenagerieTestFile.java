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
		String fileName;
		//Header
		System.out.println("*************************************************");
		System.out.println("       Menagerie V1.0: The Pet Simulator         ");
		System.out.println("*************************************************");
		
		//Arr list to hold all of the pets that are created by the user
		ArrayList<Pet> animals = new ArrayList<Pet>();
		PetWriter pWriter = new PetWriter();
		PetReader pReader = new PetReader();
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
				System.out.println("Here is your list of pets: ");
				for (Pet p : animals) {
					System.out.println(p.toString());
				}
			}
			
			else if(curChoice == 3) {
				System.out.print("Enter the name of the file: ");
				fileName = scan.next();
				pWriter.writeToFile(animals, fileName);
				System.out.println(fileName +"\nThe pets were saved to file.");
			}
			
			else if(curChoice == 4) {
				animals.clear();
				System.out.print("Enter the name of the file to read from: ");
				fileName = scan.next();
				System.out.println("\nLoaded pets from file !");
				for (Pet p : pReader.readFromFile(fileName)) {
					animals.add(p);
				}
			}
			
			else if(curChoice == 5) {
				System.out.println("Here is a simulation of a day in the life of your pets: \n");
				for (int i = 1; i < 25; i++) {
					//loop from 1 - 24 for each hour of the day
					System.out.println("Hour " + i);
					System.out.println("-------");
					for (Pet p : animals) {
						//then loop through each animal and do their random task
						System.out.println(p.act(p.getRand()));
						}
					System.out.println();
				}
			}
			
			else if(curChoice == 6) {
				animals.clear();
				System.out.println();
				System.out.println("List of pets cleared !");
			}
		
		System.out.println();
		printOptions();
		curChoice =scan.nextInt();
		}
		System.out.println("\nThank you for using Menagerie. We hope you had fun.");
		
	}
}
