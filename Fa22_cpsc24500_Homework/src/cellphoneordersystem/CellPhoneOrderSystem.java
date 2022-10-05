package cellphoneordersystem;
import java.util.ArrayList;
import java.util.Scanner;

public class CellPhoneOrderSystem {
		
	public static double phoneType(Scanner scan, ArrayList<String> finPhone) {
		System.out.print("What type of phone would you like? \n"
				+ "Enter A for Android and I for Iphone: ");
		String type = scan.next();
		if (type.equalsIgnoreCase("A")) {
			finPhone.add("Android"); 
			return 799.0;
		}
		else if (type.equalsIgnoreCase("I")) { 
			finPhone.add("Iphone");
			return 849.0;
		}
		return 0;
	}
	
	public static double screenSize(Scanner scan, ArrayList<String> finPhone) {
		System.out.print("What size of phone screen would you like? \n"
				+ "Enter 1 for 5.6\", 2 for 6.2\" or 3 for 6.7\": ");
		String size = scan.next();
		if (size.equalsIgnoreCase("1")) {
			finPhone.add("5.6\""); 
			return 1;
		}
		else if (size.equalsIgnoreCase("2")) { 
			finPhone.add("6.2\"");
			return 1.2;
		}
		else {
		finPhone.add("6.7\"");
		return 1.4;
		}
	}
	public static int phoneNum(Scanner scan) {
		System.out.println("How many phones would you like to purchase? ");
		int num = scan.nextInt();
		return num;
		
	}
	public static String choice(Scanner scan) {
		System.out.println("\nWhat add-on do you want?\n"
				+ "[C]ase (49$)\n[S]creen protector (15$)\n"
				+ "[E]ar buds (99$)\n[W]ireless charger (59$)\n"
				+ "[F]inish order");
		System.out.print("Enter the letter of your Choice: ");
		String response = scan.next();
		return response;
	}
	public static void main(String[] args) {
		ArrayList<String> completePhonePrint = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int numPhones = phoneNum(sc);
		for(int i = 0; i<numPhones; i++) {
			phoneType(sc,completePhonePrint);
			screenSize(sc, completePhonePrint);
			
			//enter while loop for add-ons
			while(choice(sc).equalsIgnoreCase("F") == false) {
				
				
				
				
			}
			System.out.println("Phone order completed: \n\n\n");
			System.out.println(completePhonePrint);
			System.out.println();
		} 
	}
	
	
}
