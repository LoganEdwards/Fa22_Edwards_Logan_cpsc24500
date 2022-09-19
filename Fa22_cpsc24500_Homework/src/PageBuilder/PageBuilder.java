package PageBuilder;

import java.util.Scanner;

public class PageBuilder {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.next();
		System.out.println("Hi there " + name + " how old are you?");
		int age = input.nextInt();
		System.out.println(age);
	}


}
