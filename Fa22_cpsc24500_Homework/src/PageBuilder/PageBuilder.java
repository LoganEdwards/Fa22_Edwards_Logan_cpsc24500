package PageBuilder;

import java.util.Scanner;

public class PageBuilder {
	
	public static void main(String[] args) {
		String blankSpace;
		Scanner input = new Scanner(System.in);
		System.out.println("************************************************");
		System.out.println("	   WEBPAGE BUILDER V1.0    			");
		System.out.println("************************************************\n");
		//setup header and 
		System.out.println("This application will help you build a basic web page\n" +
		"by asking you a series of questions. Just answer each question, and\nI'll " +
		"popultate your new web page with your responses. \n");
		
		System.out.print("What is your name? ");
		String name = input.nextLine();
		//grab name store it in name
		
		System.out.print("How old are you? ");
		int age = input.nextInt();
		//grab age store it in age
		
		System.out.print("Where do you live? ");
		blankSpace = input.nextLine();
		String location = input.nextLine();
		//grab location store it in location
		
		System.out.print("When you grow up, you want to be ... ");
		String goals = input.nextLine();
		//grab goals and store it
		
		System.out.print("What are your two favorite integers? ");
		int a = input.nextInt();
		int b = input.nextInt();
		//grab 2 ints seperated by a space and store in a and b
		
		//build webpage
		System.out.println("Here is the code for your webpage:");
		System.out.println("<html>");
		System.out.printf("<head><title>%s's Web Page</title></head>\n", name);
		System.out.println("<body>");
		System.out.printf("<h1>Welcome to %s's Web Page</h1>\n", name);
		System.out.printf("<p>I am %s years old or %s months and I live in %s.</p>\n", age, (age*12), location);
		System.out.printf("<p>When I grow up I want to be a %s</p>\n", goals);
		System.out.printf("<p>My two favorite integers are %s and %s, there quotient is: %.5s</p>\n", a,b, ((double)a/b));
		System.out.println("Thank you for visiting my webpage. ");
		System.out.println("</body>");
		System.out.println("</html>");
		
	}


}
