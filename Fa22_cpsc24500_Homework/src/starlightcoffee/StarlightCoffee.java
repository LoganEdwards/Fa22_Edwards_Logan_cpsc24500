package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {
	
	public static void printHeader() {
		System.out.println("*************************************");
		System.out.println("  STARLIGHT COFFEE PURCHASE SYSTEM");
		System.out.println("*************************************\n");
	}

	public static double pickCoffeeType(Scanner sc) {
		System.out.println("\nWhat Type of coffee would you like?");
		System.out.println("1. Americano\n2. Italiano");
		System.out.println("3. Esperesso\n4. Cappuccino");
		System.out.print("Enter the number of your choice: ");
		String response = "" + sc.nextInt();
		//return the coffee price based on response
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
		if (member.equalsIgnoreCase("y") || member.equalsIgnoreCase("yes")) { return true; }
		else if (member.equalsIgnoreCase("n") || member.equalsIgnoreCase("no")) { return false; }
		else{ System.out.println("Its a yes or no question");return false; }
	}
	public static double tipCheck(Scanner sc) {
		System.out.println("\nWhat size tip would you like to give?");
		System.out.println("1. Good Service - 10%\n2. Great Service - 15%"
				+ "\n3. Outstanding service - 20%");
		System.out.print("Enter the number of your service: ");
		String ans = "" + sc.nextInt();
		if (ans.equals("1")) { return 1.1; }
		else if (ans.equals("2")) { return 1.15; }
		else if (ans.equals("3")) { return 1.2; }
		else { System.out.println("You did it wrong :("); return 0;}
	}
	public static void printReciept(String name, double bev, double disc, double tip, double taxes, double total) {
		System.out.printf("\nHere is your final bill: %s",name);
		System.out.printf("\n%-20s $  %3.2f", "Drink Cost: ",bev);
		System.out.printf("\n%-20s $  %3.2f", "Club discount: ", disc);
		System.out.printf("\n%-20s $  %3.2f", "Tip Amount ", tip);
		System.out.printf("\n%-20s $  %3.2f", "Taxes ", taxes);
		System.out.printf("\n%-20s $  %3.2f", "Total ", total);
	}
	
	public static void main(String[] args) {
		printHeader();
		Scanner scan = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = scan.next();
		double total;
		double tip;
		double tax = 0.0875;
		//set total equal to coffee base price
		total = pickCoffeeType(scan);
		total *= pickSize(scan);
		total += shotCount(scan);
		double bevCost = total;
		double discount = 0.00;
		if (memberCheck(scan)) { 
			discount = total * 0.1;
			total *= 0.9;
		}
		double taxCost = total * tax;
		total = total * (1+tax);
		tip = bevCost * (tipCheck(scan)-1) ;
		total += tip;
		
		printReciept(name, bevCost, discount, tip, taxCost, total );
		
		System.out.println("\n\nThank you for choosing Starlight Coffee! ");
		
		//notes
		//add tax to (drink cost - discount)
		//add tip to cost of drink (no discount or tax on tip)
		//discount is applied to the cost of the drink 
	}
	
}
