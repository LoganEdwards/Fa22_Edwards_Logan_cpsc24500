package storyteller;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	/* which
	contains the main function and perhaps other functions specific to this application
	that you find useful (like one for printing the welcome message)
	*/
	public static void printHeader() {
		System.out.println("****************************************");
		System.out.println("            STORYTELLER V1.0            ");
		System.out.println("****************************************\n");
	}
	public static void printOptions(Author author, Scanner sc) {
		//grab number of lines/adj/adverb/prepositions from user
		System.out.print("\nHow many sentences would you like in your story? ");
		author.setLines(sc.nextInt());
		System.out.println("On a scale of 0 - 10 ...");
		System.out.print("\nHow frequently should adjectives be used? ");
		author.setAdj(sc.nextInt());
		System.out.print("\nHow frequently should adverbs be used? ");
		author.setAdverb(sc.nextInt());
		System.out.print("\nHow frequently should prepositions be used? ");
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
			author.makeStory(file.readFile(fName), author.getAdj(), author.getNoun(), author.getAdverb(), author.getVerb(), author.getPrep());
			System.out.print("\nWould you like to generate another story? y or n: ");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));
		
		System.out.println("Thank you for using StoryTeller ! <3");
	}
}
