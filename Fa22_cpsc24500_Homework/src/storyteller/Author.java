package storyteller;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Random;

public class Author {
	//which is responsible for generating each story.
	private int numLines;
	private int numAdj;
	private int numNoun;
	private int numAdverb;
	private int numVerb;
	private int numPrep;
	
	//constructor for a call with no arguments, defaults to 1
	//mainly using this for testing
	public Author() {
		setLines(1);
		setAdj(1);
		setNoun(1);
		setAdverb(1);
		setVerb(1);
		setPrep(1);
	}
	
	//constructor for the input from user
	public Author(int line, int adj, int noun, int adverb, int verb, int prep) {
		setLines(line);
		setAdj(adj);
		setNoun(noun);
		setAdverb(adverb);
		setVerb(verb);
		setPrep(prep);
	}
	
	public int getLines() { return numLines; }
	public void setLines(int lines) { 
		if (lines != 0) numLines = lines; 
		else { numLines = 1; }
	}

	public int getAdj() { return numAdj; }
	public void setAdj(int adj) { numAdj = adj; }
	
	public int getNoun() { return numNoun; }
	public void setNoun(int noun) { numNoun = noun; }
	
	public int getAdverb() { return numAdverb; }
	public void setAdverb(int adverbs) { numAdverb = adverbs; }
	
	public int getVerb() { return numVerb; }
	public void setVerb(int verbs) { numVerb = verbs; }
		
	public int getPrep() { return numPrep; }
	public void setPrep(int preps) { numPrep = preps; }
		
	public void generateSentence(LinkedHashMap<String, ArrayList<String>> words, int numAdj, int numNoun, int numAdverb, int numVerb, int numPrep ) {
		//generate a sentence while passing in a random index from each of the specified arrayLists ie random noun, random verb... etc.
		
		//The {<adjective>} <subject> <predicate> {<adverb>}{<preposition> the <object of preposition>}  ~Formula
		
/*Your program will first read this file of words into memory. Once the words are loaded, the application will choose nouns to replace the <subject> and <object-of-preposition>
parts of the sentence, verbs to replace the <predicate> part, adjectives to replace the <adjective> part, and adverbs to replace the
<adverb> part
*/
		Random rnd = new Random();
		String xNoun = words.get("n").get(rnd.nextInt(words.get("n").size()));
		
				
		System.out.printf("\nThe %s", xNoun);
	}
	
	public void makeStory(LinkedHashMap<String, ArrayList<String>> words, int numAdj, int numNoun, int numAdverb, int numVerb, int numPrep) {
		//use generate sentence to make a new random sentence for each line
		for (int i = 0; i < numLines;i++) {
			generateSentence(words, numAdj, numAdverb, numNoun, numVerb, numPrep);
		}
	}
	
	
}
