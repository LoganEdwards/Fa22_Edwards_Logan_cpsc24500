package cellphoneordersystem;
import java.util.Scanner;

public class CellPhoneOrderSystem {
		
	public static double phoneType(Scanner scan, String[] finPhone) {
		
		return 0;
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
		do {
			choice(sc);	
			
		} while(choice(sc).equalsIgnoreCase("F") == false);
	}
	
}
