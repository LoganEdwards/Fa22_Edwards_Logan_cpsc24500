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
		else {
			System.out.println("That is close enough to A");
			return 799.0;
		}
	}
	
	public static double screenSize(Scanner scan, ArrayList<String> finPhone) {
		System.out.print("What size of phone screen would you like? \n"
				+ "Enter 1 for 5.6\", 2 for 6.2\" or 3 for 6.7\": ");
		int size = scan.nextInt();
		if (size == 1) {
			finPhone.add("5.6\""); 
			return 1;
		}
		else if (size == 2) { 
			finPhone.add("6.2\"");
			return 1.2;
		}
		else if (size == 3){
		finPhone.add("6.7\"");
		return 1.4;
		}
		else {
			System.out.println("That is close enough to 1");
			return 1;
		}
	}
	
	public static double storageSize(Scanner scan, ArrayList<String> finPhone) {
		System.out.print("How much storage would you like? \n"
				+ "Enter 64, 128, or 256: ");
		int storage = scan.nextInt();
		if (storage == 64) {
			finPhone.add("64GB"); 
			return 0;
		}
		else if (storage == 128) { 
			finPhone.add("128GB");
			return 100;
		}
		else {
		finPhone.add("256GB");
		return 250;
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
	
	public static ArrayList<String> copyPhone(ArrayList<String> ogPhone) {
		//couldn't only use the .clear() method because it would clear from all memory :(
		//have to create a hard copy of the list before clearing the temp phone holder
		  ArrayList<String> copy = new ArrayList<String>();
		  for (String item: ogPhone) {
		    copy.add(item);
		  }
		  return copy;
		}
	
	public static void main(String[] args) {
		//I know this is not the way to do this but I wanted to mess around with Array lists
		
		//keep track of phone info in tempPhone and add each phone into completedPhones
		ArrayList<String> tempPhone = new ArrayList<String>();
		ArrayList<ArrayList<String>> completedPhones = new ArrayList<ArrayList<String>>();
		
		Scanner sc = new Scanner(System.in);
		int numberPhones = phoneNum(sc);
		double total = 0;
		String currChoice;
		String phoneCost = "";
		double overallTotal = 0;
		
		//for loop for each phone
		for(int i = 0; i<numberPhones; i++) {
			System.out.println("Let's configure phone #" + (i+1) + "...");	
			total += phoneType(sc,tempPhone);
			total *= screenSize(sc, tempPhone);
			total += storageSize(sc, tempPhone);
			
			//enter while loop for add-ons
			currChoice = choice(sc);
			while(currChoice.equalsIgnoreCase("F") == false) {
				
				if (currChoice.equalsIgnoreCase("C")) { 
					total += 49;
					tempPhone.add("Case");
				}

				else if (currChoice.equalsIgnoreCase("S")) {
					total += 15;
					tempPhone.add("Screen Protector");
				}
				
				else if (currChoice.equalsIgnoreCase("E")) {
					total += 99;
					tempPhone.add("Ear Buds");
				}
				

				else if (currChoice.equalsIgnoreCase("W")) {
					total += 59;
					tempPhone.add("Wireless Charger");
				}
				
				else { System.out.println("Type a valid letter please ! ");	}
				
				currChoice = choice(sc);
			}
			
			
			//rounding the total to 2 decimal points before adding it as a string to the current Phone
			phoneCost = String.format("%.2f",total);
			tempPhone.add("($" + phoneCost + ")");
			overallTotal += total;
			total = 0;
			
			completedPhones.add(copyPhone(tempPhone));
			tempPhone.clear();
			System.out.println("Current Phone order completed! \n\n");			
		
		} 
		System.out.println("\nHere is a summary of your order:\n");
		
		//nested for loops to itterate over each item of each phone
		for (int i = 0; i < completedPhones.size(); i++) {
			for (int x = 0; x < completedPhones.get(i).size(); x++) {
				if (x < 3) { 
					System.out.print(completedPhones.get(i).get(x) + " ");
				}
				else if (x < completedPhones.get(i).size() - 1){
					System.out.print(" / " + completedPhones.get(i).get(x));
				}
				else { 
					System.out.println("  " + completedPhones.get(i).get(x));
				}
			}
			System.out.println();
		}
		System.out.printf("\nYour total order cost is %.2f", overallTotal);
		System.out.println("\n\nThank you for your order");
	}
}
