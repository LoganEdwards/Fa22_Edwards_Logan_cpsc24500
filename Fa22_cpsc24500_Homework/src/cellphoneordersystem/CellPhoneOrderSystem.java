package cellphoneordersystem;
import java.util.Scanner;

public class CellPhoneOrderSystem {
		
	public static double phoneType(Scanner scan, String[] finPhone) {
		
		return 0;
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
		String[] finalPhonePrint = {};
		Scanner sc = new Scanner(System.in);
		int numPhones = phoneNum(sc);
		for(int i = 0; i<numPhones; i++) {
			while(choice(sc).equalsIgnoreCase("F") == false) {
				
				
				
				
			}
			System.out.println("Phone order completed: \n\n\n");
		} 
	}
	
	
}
