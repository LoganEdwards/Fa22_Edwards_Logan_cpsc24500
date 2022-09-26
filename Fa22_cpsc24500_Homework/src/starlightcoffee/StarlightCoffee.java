package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {

	public static double pickCoffeeType(Scanner sc) {
		System.out.println("What Type of coffee would you like?");
		System.out.println("1. Americano\n2. Italiano");
		System.out.println("3. Esperesso\n4. Cappuccino");
		System.out.print("Enter the number of your choice: ");
		String response = "" + sc.nextInt();
		//return based on response the coffee price
		if (response.equals("1")) {	return 2.25; }
		else if(response.equals("2")) { return 2.75; }
		else if(response.equals("3")) {	return 3.50; }
		else if(response.equals("4")) { return 3.75; }
		else {System.out.println("Enter a valid number please");}
		return 0;
	}
	public static double pickSize(Scanner sc) {
		System.out.println("\nWhat Size coffee would you like?");
		System.out.println("1. Tall\n2. Grande\n3. Venti");
		System.out.print("Enter the number of your choice: ");
		String ans = "" + sc.nextInt();
		//return price multiplier based on size
		if (ans.equals("1")) { return 1; }
		else if (ans.equals("2")) { return 1.2; }
		else if (ans.equals("3")) { return 1.4; }
		return 0;
	}
	public static double shotCount(Scanner sc) {
		System.out.print("\nHow many shots of espresso would you like? ");
		int shotNum = sc.nextInt();
		return (0.5 * shotNum);
	}
	public static boolean memberCheck(Scanner sc) {
		System.out.print("\nAre you a Starlight Member?\n"
				+ "Please enter y or n ");
		String member = sc.next();
		if (member.equalsIgnoreCase("y")) { return true; }
		else{ return false; }
	}
	
	public static void main(String[] args) {
		System.out.println("********Fix header later*******\n");
		
		Scanner scan = new Scanner(System.in);
		double total;
		//set total equal to coffee base price
		total = pickCoffeeType(scan);
		total *= pickSize(scan);
		total += shotCount(scan);
		if (memberCheck(scan)) { 
			
		}
		System.out.printf("%.2f",total);
		//add tax to (drink cost - discount)
		//add tip to cost of drink (no discount or tax on tip)
		//discount is applied to the cost of the drink 
	}
	
}
