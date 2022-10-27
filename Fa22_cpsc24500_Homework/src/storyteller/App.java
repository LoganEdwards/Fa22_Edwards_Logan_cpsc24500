package storyteller;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	/* App does a lot of the printing and inputting
	 * makes objects of wordFileReader and Author to generate stories
	*/
	public static void printHeader() {
		System.out.println("****************************************");
		System.out.println("            STORYTELLER V1.0            ");
		System.out.println("****************************************\n");
		
		System.out.println("Welcome to StoryTeller, a sophisticated electronic\r\n"
				+ "author. This program reads from a list of words of\r\n"
				+ "various parts of speech and creates a story from\r\n"
				+ "them. You can tune the richness of the writing by\r\n"
				+ "changing how frequently adjectives, adverbs, and\r\n"
				+ "prepositions should be included\n");
	}
	public static void printOptions(Author author, Scanner sc) {
		//grab number of lines/adj/adverb/prepositions from user
		System.out.print("\nHow many sentences would you like in your story? ");
		author.setLines(sc.nextInt());
		System.out.println("On a scale of 0 - 10 ...");
		System.out.print("\n\tHow frequently should adjectives be used? ");
		author.setAdj(sc.nextInt());
		System.out.print("\n\tHow frequently should adverbs be used? ");
		author.setAdverb(sc.nextInt());
		System.out.print("\n\tHow frequently should prepositions be used? ");
		author.setPrep(sc.nextInt());
		}
	
	public static void main(String[] args) {
		WordFileReader file = new WordFileReader();
		Author author = new Author();
		Scanner sc = new Scanner(System.in);
		String fName;
		String choice;
		printHeader();
		//Grab file name from user
		System.out.print("Enter the name of the file to read: ");
		fName = sc.next();
		do { 
			printOptions(author, sc);
			System.out.println("Here it is: ");
			author.makeStory(file.readFile(fName), author.getAdj(), author.getAdverb(), author.getPrep());
			System.out.print("\nWould you like to generate another story? y or n: ");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));
		
		System.out.println("\nThank you for using StoryTeller ! <3");
	}
}
