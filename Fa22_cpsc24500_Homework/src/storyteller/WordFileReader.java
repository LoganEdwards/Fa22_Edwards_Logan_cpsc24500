package storyteller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;

public class WordFileReader {
	//a return function called readFile that reads the words into memory.	
	//this method returns a linked HashMap that holds all the words with designated types, n, v, adverb ... etc.
	public LinkedHashMap<String,ArrayList<String>> readFile(String fileName) {
		try {
			Scanner fsc = new Scanner(new File(fileName));
			String line;
			String[] tempParts;
			//String[] types = {"adj", "n", "adv", "v", "prep"};
			LinkedHashMap<String,ArrayList<String>> parts = new LinkedHashMap<String,ArrayList<String>>();
			ArrayList<String> adj = new ArrayList<String>();
			ArrayList<String> noun = new ArrayList<String>();
			ArrayList<String> adv = new ArrayList<String>();
			ArrayList<String> verb = new ArrayList<String>();
			ArrayList<String> preps = new ArrayList<String>();
			
			//open file and read each line
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				tempParts = line.split(" ");
				
				//check for the second part of the line and add the first word to its designated Arr list
				if (tempParts[1].equalsIgnoreCase("adj")) {
					adj.add(tempParts[0]);
				}
				else if (tempParts[1].equalsIgnoreCase("n")) {
					noun.add(tempParts[0]);
				}
				else if (tempParts[1].equalsIgnoreCase("adv")) {
					adv.add(tempParts[0]);
				}
				else if (tempParts[1].equalsIgnoreCase("v")) {
					verb.add(tempParts[0]);
				}
				else if (tempParts[1].equalsIgnoreCase("prep")) {
					preps.add(tempParts[0]);
				}
				
			}
			
			fsc.close();
			//add each Arr list to the linked hashmap with its corresponding type
			parts.put("adj", adj);
			parts.put("n", noun);
			parts.put("adv", adv);
			parts.put("v", verb);
			parts.put("prep", preps);
			
			return parts;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
		
	}	
	
}
