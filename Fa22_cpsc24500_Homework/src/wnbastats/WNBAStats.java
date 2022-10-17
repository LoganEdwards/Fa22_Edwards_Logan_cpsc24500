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
		System.out.println("What would you like to see?");
		System.out.println("1. Eastern Conference \n2. Western Conference");
		System.out.println("3. Combined \n4. Exit");
		System.out.print("Enter the number of your choice: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static void printResults() {
		
	}
	
	public static void createMap(ArrayList<String> names, ArrayList<Integer> record) {
		
	}
	
	public static void main(String[] args) {
		LinkedHashMap<ArrayList<String>, ArrayList<Integer>> allTeamMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		ArrayList<String> allTeams = new ArrayList<String>();	
		ArrayList<Integer> winLoss = new ArrayList<Integer>();
		String[] eastern = new String[6];
		int[] easternWL = new int[12];
		String[] western = new String[6];
		int[] westernWL = new int[12];
		String line;
		String[] nameParts;
		String name ="";
		//PRINT HEADER
		System.out.println("**********************************");
		System.out.println("       2022 WNBA STANDINGS		");
		System.out.println("**********************************");
		try { 
			//open file and read the lines separated by tabs
			//file 
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
		int curChoice = showMenu();
		while (curChoice != 4) {
			if (curChoice == 1) {
				System.out.println("print eastern conference");
			}
			else if (curChoice == 2) {
				System.out.println("print western conference");
			}
			else if (curChoice == 3) {
				System.out.println("print combined conference");
			}
			curChoice = showMenu();
		}
		
	}
	
}
