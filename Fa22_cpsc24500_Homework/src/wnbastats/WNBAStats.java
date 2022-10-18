package wnbastats;

import java.io.File;
import java.util.LinkedHashMap;	//messed around with Hash map but it was easier to do without it
import java.util.ArrayList;
import java.util.Scanner;

public class WNBAStats {
	/*
	 * do
	 * 		show menu
	 * 		if the want to see eastern
	 * 			print eastern menu
	 * 		if the want to see western
	 * 			print western menu
	 * 		
	 * printing results 
	 * 		for every line in that conference
	 * 			split it
	 * 			nameParts[0] is name
	 * 			nameParts[1] is wins
	 * 			nameParts[2] is losses
	 * 			compute pct and gb
	 * 			print the teams info
	 */
	public static String getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the name of the file to read: ");
		return sc.nextLine();
		}
	
	public static int showMenu() {
		System.out.println("\nWhat would you like to see?");
		System.out.println("1. Eastern Conference \n2. Western Conference");
		System.out.println("3. Combined \n4. Exit");
		System.out.print("Enter the number of your choice: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static void printResults(String[] names, int[] wins, int[] losses, double[] pct, double[] gb) {
		System.out.println();
		System.out.printf("Team name %15s %5s %5s %5s","Wins", "Losses","PCT", "GB");
		for (int i = 0; i < pct.length; i++) {
			System.out.printf("\n%-10s %15s %6s %6.3f %6.3f",names[i], wins[i], losses[i] ,pct[i], gb[i]);
		}
	}
	
	public static double[] calcPCT(int[] arr) {
	//make new array to hold all values including 0s
		double[] calcArr = new double[arr.length];
		//make a final array to hold all #'s except 0s
		double[] finArr = new double [arr.length/2];
		//divide the wins by win + loss 
		for (int i = 0; i < arr.length; i+=2) {		
			calcArr[i] = arr[i] / (double)(arr[i+1] + arr[i]);	
		}
		//the zeros are on the odd # index so we avoid those
		for (int j = 0; j< finArr.length; j++) {
			finArr[j] = calcArr[j*2];
		}
		return finArr;
	}
	
	public static double[] calcGB(int[] arr) {
		double[] gbArr = new double[arr.length/2];
		return gbArr;
	}
	
	public static void main(String[] args) {
		//LinkedHashMap<ArrayList<String>, ArrayList<Integer>> allTeamMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		ArrayList<String> allTeams = new ArrayList<String>();	
		ArrayList<Integer> winLoss = new ArrayList<Integer>();
		//eastern names and winloss
		String[] eastern = new String[6];
		int[] easternWL = new int[12];
		//western names and winloss
		String[] western = new String[6];
		int[] westernWL = new int[12];
		
		//pct for each team
		double[] eastPCT;
		double[] westPCT;
		
		String line;
		String[] nameParts;
		String name ="";
		
		//PRINT HEADER
		System.out.println("**********************************");
		System.out.println("       2022 WNBA STANDINGS		");
		System.out.println("**********************************");
		try { 
			//open file and read the lines separated by tabs
			Scanner scFile = new Scanner(new File(getFile()));
			while (scFile.hasNextLine()) {
				line = scFile.nextLine().trim();
				nameParts = line.split("\t");
				
				//check if its a conference line
				if (nameParts[0].contains("Conference")) {  }
				else {
						name = nameParts[0];
						allTeams.add(name);		
				}
				
				for(int i = 1; i < nameParts.length; i++) {
					winLoss.add(Integer.parseInt(nameParts[i]));
				}
				
				//allTeamMap.put(allTeams, winLoss);
			}
			
			//remove the blank line between the teams
			allTeams.remove(6);
			
			
			for (int i = 0; i < eastern.length; i++) {
				//set the first 6 teams to eastern
				eastern[i] = allTeams.get(i);
				//set the last 6 teams to western size= 12 - 6 then add 1,2,3 to keep the order right
				western[i] = allTeams.get(allTeams.size()-western.length + i);
			}
			//set the individual teams win loss records 
			for (int j = 0; j < easternWL.length; j++) {
				easternWL[j] = winLoss.get(j);
				westernWL[j] = winLoss.get(winLoss.size() - westernWL.length + j);
			}
			
			
			scFile.close();
			
		} catch (Exception ex ) {
			System.out.println(ex);
			System.out.println("A problem has happened");
		}		
		System.out.println("The teams have been read.");
		try {
			int curChoice = showMenu();
			while (curChoice != 4) {
				if (curChoice == 1) {
					eastPCT = calcPCT(easternWL);
					//eastGB = calcGB(easternWL);
					System.out.println("\nPrinting eastern conference standings");
					printResults(eastern, easternWL, eastPCT, eastPCT);
					
				}
				else if (curChoice == 2) {
					westPCT = calcPCT(westernWL);
					System.out.println("\nPrinting eastern conference standings");
					printResults(western, westernWL, westPCT, westPCT);
				}
				else if (curChoice == 3) {
					System.out.println("\nPrinting combined conference standings");
					//printResults(allTeamPCT);
				}
				curChoice = showMenu();
		
			}
		}	catch (Exception ex) {
			System.out.println(ex);
			System.out.println("That is not a valid option");
		}
	}
	
}
