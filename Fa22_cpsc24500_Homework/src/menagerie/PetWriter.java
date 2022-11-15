package menagerie;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;	

public class PetWriter {
	//Writes all pets to a file of a user specified name
	
	public void writeToFile(ArrayList<Pet> pets, String outFileName) {	
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outFileName))));
			for (Pet p : pets) {
				pw.println(p.toString());	
			}
			 pw.close();
		}catch(Exception ex) {
			//ex.printStackTrace();
		}
	}
}
