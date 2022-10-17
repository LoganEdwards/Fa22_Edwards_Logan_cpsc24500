package wnbastats;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class WNBAStats {
	
	/*open file
	 * read every line in file	
	 * 		if its a conference line,
	 * 			set target to either eastern or western
	 * 		else if not a blank line
	 * 			add line to the target location
	 * close file
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
	public static void showMenu() {
		
	}
	
	public static void printResults() {
		
	}
	
	public static void createMap(ArrayList<String> names, ArrayList<Integer> record) {
		
	}
	
	public static void main(String[] args) {
		LinkedHashMap<ArrayList<String>, ArrayList<Integer>> easternMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		LinkedHashMap<ArrayList<String>, ArrayList<Integer>> westernMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		LinkedHashMap<ArrayList<String>, ArrayList<Integer>> allTeamMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		ArrayList<String> allTeams = new ArrayList<String>();	
		ArrayList<Integer> winLoss = new ArrayList<Integer>();
		String[] eastern = new String[6];
		String[] western = new String[6];
		String line;
		String[] nameParts;
		String name ="";
		try { 
			//open file and read the lines separated by tabs
			Scanner scFile = new Scanner(new File("wnba.txt"));
			while (scFile.hasNextLine()) {
				line = scFile.nextLine().trim();
				nameParts = line.split("\t");	
				//check if its a conference line
				if (nameParts[0].contains("Conference")) {  }
				else {
						name = nameParts[0];
						allTeams.add(name);		
				}
				for(int i = 1; i < nameParts.length; i++)
					winLoss.add(Integer.parseInt(nameParts[i]));
				
				teamMap.put(allTeams, winLoss);
			}
			
			//remove the blank line between the teams
			allTeams.remove(6);
			
			
			for (int i = 0; i < eastern.length; i++) {
				//set the first 6 teams to eastern
				eastern[i] = allTeams.get(i);
				//set the last 6 teams to western size= 12 - 6 then add 1,2,3 to keep the order right
				western[i] = allTeams.get(allTeams.size()-western.length + i);
			}
			
		} catch (Exception ex ) {
			System.out.println("A problem has happened");
		}
//		for (String n : eastern) { System.out.println(n); }
//		System.out.println();
//		for (String n : western) { System.out.println(n); }
		for (int x : winLoss) { System.out.println(x); }
	}
	
}
