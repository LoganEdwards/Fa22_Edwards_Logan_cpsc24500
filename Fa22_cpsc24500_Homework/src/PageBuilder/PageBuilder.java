package PageBuilder;

import java.util.Scanner;

public class PageBuilder {
	
	public static void main(String[] args) {
		String blankSpace;
		Scanner input = new Scanner(System.in);
		System.out.println("************************************************");
		System.out.println("	   WEBPAGE BUILDER V1.0    			");
		System.out.println("************************************************\n");
		
		System.out.println("This application will help you build a basic web page\n" +
		"by asking you a series of questions. Just answer each question, and\nI'll " +
		"popultate your new web page with your responses. ");
		
		System.out.print("What is your name? ");
		String name = input.nextLine();
		
		System.out.print("How old are you? ");
		int age = input.nextInt();
		
		System.out.print("Where do you live? ");
		blankSpace = input.nextLine();
		String location = input.nextLine();
		//System.out.println(location);
		
		System.out.print("When you grow up, you want to be ... ");
		String goals = input.nextLine();
		
		//System.out.println(goals);
		System.out.print("What are your two favorite integers? ");
		int a = input.nextInt();
		int b = input.nextInt();
		
		System.out.println("Here is the code for your webpage:");
		System.out.println("<html>");
		System.out.println("<head><title>"+ name +"'s Web Page</title></head>");
		System.out.println("<body>");
		System.out.println("<h1>Welcome to "+ name + "'s Web Page</h1>");
		System.out.println("<p>I am " + age + " years old and I live in " + location + ".</p>");
		
	}


}
