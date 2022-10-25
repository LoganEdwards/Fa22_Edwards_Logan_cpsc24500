package storyteller;

public class Author {
	//which is responsible for generating each story.
	private int numLines;
	private int numAdj;
	private int numAdverb;
	private int numPrep;
	
	//constructor for a call with no arguments, defaults to 1
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
	public void setLines(int lines) { numLines = lines; }

	public int getAdj() { return numAdj; }
	public void setAdj(int adj) { numAdj = adj; }
	
	public int getAdverb() { return numAdverb; }
	public void setAdverb(int adverbs) { numAdverb = adverbs; }
	
	public int getPrep() { return numPrep; }
	public void setPrep(int preps) { numPrep = preps; }
		
	
	
}
