package storyteller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;

public class WordFileReader {
	//a static function called readFile that reads the words into memory.	
	//fix use of arrayList later, either split between words and type, or use all together
	public LinkedHashMap<String,ArrayList<String>> readFile(String fileName) {
		try {
			Scanner fsc = new Scanner(new File(fileName));
			String line;
			String[] tempParts;
			String[] types = {"adj", "n", "adv", "v", "prep"};
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
			parts.put("verb", verb);
			parts.put("prep", preps);
			
//			testing to make sure it has the right output
//			ArrayList<String> x = parts.get("adv");
//			for (String a : x) {
//				System.out.println(a);
//			}
			
			return parts;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
		
	}	
	
}
