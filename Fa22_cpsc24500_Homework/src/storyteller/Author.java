package storyteller;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Random;

public class Author {
	//Responsible for generating each story. 
	//Uses the input gained in app to make sentences and stories
	
	private int numLines;
	private int numAdj;
	private int numAdverb;
	private int numPrep;
	
	//constructor for a call with no arguments, defaults to 1
	//mainly using this for testing
	public Author() {
		setLines(1);
		setAdj(1);
		setAdverb(1);
		setPrep(1);
	}
	
	//constructor for the input from user
	public Author(int line, int adj, int adverb, int prep) {
		setLines(line);
		setAdj(adj);
		setAdverb(adverb);
		setPrep(prep);
	}
	
	public int getLines() { return numLines; }
	public void setLines(int lines) { 
		if (lines != 0) numLines = lines; 
		else { numLines = 1; }
	}

	public int getAdj() { return numAdj; }
	public void setAdj(int adj) { numAdj = adj; }
	
	public int getAdverb() { return numAdverb; }
	public void setAdverb(int adverbs) { numAdverb = adverbs; }
	
	public int getPrep() { return numPrep; }
	public void setPrep(int preps) { numPrep = preps; }
	
	public boolean genChance(int max) {
		//generate a random number from 1 to 10
		Random rnd = new Random();
		int x = rnd.nextInt(10) + 1;
		//return false if max is 0
		if (max == 0) { return false; }
		//check if x is less than or equal to max
		if (x <= max) {
			return true;
		}
		return false;
	}
		
	public void generateSentence(LinkedHashMap<String, ArrayList<String>> words, int numAdj, int numAdverb, int numPrep) {
		//generate a sentence while passing in a random index from each of the specified arrayLists ie random noun, random verb... etc.
		
		//The {<adjective>} <subject> <predicate> {<adverb>}{<preposition> the <object of preposition>}  ~Formula
	
		//use blank Strings so that it won't mess up the print Formatted even if its passed in
		//only initializing these now because they are used in both print statements but are sometimes left blank
		String xAdj = "";
		String xAdverb = "";
		Random rnd = new Random();
		//making variables to get random indexes from arr lists to pass into the formatted print statement
		String subject = words.get("n").get(rnd.nextInt(words.get("n").size())) + " "; 
		String predicate = words.get("v").get(rnd.nextInt(words.get("v").size())) + " ";
		
		if (genChance(numAdj)) {
			xAdj = words.get("adj").get(rnd.nextInt(words.get("adj").size())) + " ";
		}
		if (genChance(numAdverb)) {
			xAdverb = words.get("adv").get(rnd.nextInt(words.get("adv").size())) + " ";
		}
		if (genChance(numPrep)) {
			String preposition = words.get("prep").get(rnd.nextInt(words.get("prep").size())) + " ";
			String objOfPrep = words.get("n").get(rnd.nextInt(words.get("n").size()));
			//if we do have a preposition then the formula will change so I have a blank return in this if statement to skip the second return statement
			System.out.printf("\nThe %s%s%s%s%sthe %s",xAdj, subject, predicate, xAdverb, preposition, objOfPrep);
			return;
		}
		
		else {		
		//different formula for sentence with no preposition
		System.out.printf("\nThe %s%s%s%s",xAdj, subject, predicate, xAdverb);
		}
		
	}
	public void makeStory(LinkedHashMap<String, ArrayList<String>> words, int numAdj, int numAdverb, int numPrep) {
		//use generate sentence to make a new random sentence for each line
		for (int i = 0; i < numLines;i++) {
			generateSentence(words, numAdj, numAdverb, numPrep);
		}
	}
	
	
}
