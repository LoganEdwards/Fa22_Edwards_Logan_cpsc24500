package menagerie;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PetReader {

	//reads all pets from a user specified file and return them as an arr list
	
	public ArrayList<Pet> readFromFile(String fName){
		ArrayList<Pet> animals = new ArrayList<Pet>();
		String line;
		String[] parts;
		String tempType;
		//making temp variables to hold the pets: name, age, and weight to make a new Pet
		String tName;
		int tAge;
		double tWeight;
		try {
			Scanner fsc = new Scanner(new File(fName));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				parts = line.split("\t");
				tempType = parts[0];
				tName = parts[1];
				tAge = Integer.parseInt(parts[2]);
				tWeight = Double.parseDouble(parts[3]);
				if (tempType.equalsIgnoreCase("dog")) {
					animals.add(new Dog(tName, tAge, tWeight));
				}
				else if(tempType.equalsIgnoreCase("Cat")) {
					animals.add(new Cat(tName, tAge, tWeight));
				}
				else {
					animals.add(new Fish(tName, tAge, tWeight));
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return animals;
	}
	
}
