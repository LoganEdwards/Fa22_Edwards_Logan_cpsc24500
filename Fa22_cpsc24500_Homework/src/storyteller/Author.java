package storyteller;

public class Author {
	//which is responsible for generating each story.
	private int numLines;
	private int numAdj;
	private int numAdverb;
	private int numPrep;
	
	public Author(int line, int adj, int adverb, int prep) {
		setLines(line);
		setAdj(adj);
		setAdverb(adverb);
		setPrep(prep);
	}
	
	public void setLines(int lines) { numLines = lines; }
	public int getLines() { return numLines; }
	
	public void setAdj(int adj) { numAdj = adj; }
	public int getAdj() { return numAdj; }
	
	public void setAdverb(int adverbs) { numAdverb = adverbs; }
	public int getAdverb() { return numAdverb; }
	
	public void setPrep(int preps) { numPrep = preps; }
	public int getPrep() { return numPrep; }

	
}
