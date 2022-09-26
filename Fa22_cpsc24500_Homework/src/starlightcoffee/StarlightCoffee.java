package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {

	public static double pickCoffeeType(Scanner sc) {
		System.out.println("What Size coffee would you like?");
		System.out.println("1. Americano\n2. Italiano");
		System.out.println("3. Esperesso\n4. Cappuccino");
		System.out.print("Enter the number of your choice: ");
		String response = "" + sc.nextInt();
		//return based on response the coffee price 
		if (response.equals("1")) {	return 2.25; }
		else if(response.equals("2")) { return 2.75; }
		else if(response.equals("3")) {	return 3.50; }
		else if(response.equals("4")) { return 3.75; }
		return 0.0;
	}
	public static int pickSize(Scanner sc) {
		return 1;
	}
	public static int shotCount(Scanner sc) {
		return 1;
	}
	public static boolean memberCheck(Scanner sc) {
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("********Fix header later*******\n");
		
		Scanner scan = new Scanner(System.in);
		Double coffeePrice = pickCoffeeType(scan);
		pickSize(scan);
		shotCount(scan);
		memberCheck(scan);
		//add tax to (drink cost - discount)
		//add tip to cost of drink (no discount or tax on tip)
		//discount is applied to the cost of the drink 
	}
	
}
