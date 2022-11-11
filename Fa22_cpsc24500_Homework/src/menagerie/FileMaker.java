package menagerie;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;	

public class FileMaker {
	
	public void writeToFile(ArrayList<Pet> pets, String outFileName) {	
		try {
		//	Scanner fsc = new Scanner(new File(fileName));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outFileName))));
			for (Pet p : pets) {
				pw.println(p.toString());
				//System.out.println(p.toString());
				//pets.add(new Pet(parts[0], Integer.parseInt(parts[1], Double.parseDouble(parts[2]))));
			}
			 pw.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
