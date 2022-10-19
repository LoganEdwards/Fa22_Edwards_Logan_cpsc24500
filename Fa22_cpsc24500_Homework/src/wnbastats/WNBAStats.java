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
	
	public static void printResults(String[] names, int[] wins, int[] losses, double[] pct, String[] gb) {
		System.out.println();
		System.out.printf("%-25s%10s%10s%10s%7s","Team name", "Wins", "Losses","PCT", "GB");
		for (int i = 0; i < pct.length; i++) {
			System.out.printf("\n%-25s%10d%10d%10.3f%7s",names[i], wins[i], losses[i], pct[i], gb[i]);
		}
	}
	
	public static double[] calcPCT(int[] arrW, int[] arrL) {
	//make new array to hold all values of wins / wins + loss
		double[] calcArr = new double[arrW.length];
		//divide the wins by win + loss 
		for (int i = 0; i < arrW.length; i++) {		
			calcArr[i] = arrW[i] / (double)(arrW[i] + arrL[i]);	
		}
		return calcArr;
	}
	
	public static String[] calcGB(int[] arrOfWins) {
		String[] gbArr = new String[arrOfWins.length];
		for (int i = 0; i< gbArr.length; i++) {
			if (i == 0) { gbArr[i] = "-"; }
			else {
				gbArr[i] = ((double)arrOfWins[0] - arrOfWins[i]) + ""; 
			}
		}
		
		return gbArr;
	}
	
	public static int[] sortedCombinedList(int[] wins1, int[] wins2) {
		//sorting the two conferences by the wins of their teams
		int max;
		int tempIndex;
		int temp;
		int[] tempList = new int[wins1.length + wins2.length];
		int[] finList = new int[tempList.length];
		int[] indexes = new int[wins1.length + wins2.length];
		int[] indexList = new int[wins1.length + wins2.length];
		for(int i = 0; i < wins1.length + wins2.length; i++) {
			indexes[i] = i;
			if (i < wins1.length) {
				tempList[i] = wins1[i];
			}
			else {
				tempList[i] = wins2[i-6];
			}
		}
	
		
		//sort the wins and keep track of the indexes 
		for (int x = 0; x < tempList.length; x++) {
			max = tempList[x];
			tempIndex = x;
			//System.out.println(max + " " + tempIndex);
			for (int z = x; z < tempList.length-1; z++) {
				if(max < tempList[z + 1]) {
					System.out.println(max + "		" + tempIndex + " Before");
					max = tempList[z+1];
					tempIndex = z+1;
					System.out.println(max + "		" + tempIndex + " after");
				}
			}
			finList[x] = max;
			indexList[x] = tempIndex;
		}
		return indexList;
	}
	
	public static void main(String[] args) {
		//LinkedHashMap<ArrayList<String>, ArrayList<Integer>> allTeamMap = new LinkedHashMap<ArrayList<String>, ArrayList<Integer>>();
		ArrayList<String> allTeams = new ArrayList<String>();	
		ArrayList<Integer> winLoss = new ArrayList<Integer>();
		//eastern names and win + loss
		String[] eastern = new String[6];
		int[] easternW = new int[6];
		int[] easternL = new int[6];
		//western names and win + loss
		String[] western = new String[6];
		int[] westernW = new int[6];
		int[] westernL = new int[6];
		
		//pct for each team
		double[] eastPCT;
		double[] westPCT;
		
		//GB for each team
		String[] eastGB;
		String[] westGB;
		
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
			
			//set the individual teams win + loss records first 12 #'s are eastern
			for (int j = 0; j < easternW.length; j++) {
				for (int z = 0; z < 2; z++) {	
					if ((z % 2) == 0) {
						//0 2 4 6 8 10 
						easternW[j] = winLoss.get(j * 2);
					}
					else {
						//1 3 5 7 9 11 
						easternL[j] = winLoss.get((j *2) + z);
					}
				}
			}
			for (int x = 0;x < westernW.length; x++) {
				for (int z = 12; z < 14; z++) {	
					if ((z % 2) == 0) {
						//12 14 16 18 20 22 
						westernW[x] = winLoss.get((x * 2) + z);
					}
					else {
						//13 15 17 19 21 23
						westernL[x] = winLoss.get((x * 2 ) + z);
					}
				}	
		}
			
			scFile.close();
			
		} catch (Exception ex ) {
			System.out.println("A problem has happened");
		}		
		System.out.println("The teams have been read.");
		try {
			int curChoice = showMenu();
			while (curChoice != 4) {
				if (curChoice == 1) {
					eastPCT = calcPCT(easternW, easternL);
					eastGB = calcGB(easternW);
					System.out.println("\nPrinting eastern conference standings");
					printResults(eastern, easternW, easternL, eastPCT, eastGB);
					
				}
				else if (curChoice == 2) {
					westPCT = calcPCT(westernW, westernL);
					westGB = calcGB(westernW);
					System.out.println("\nPrinting eastern conference standings");
					printResults(western, westernW, westernL, westPCT, westGB);
				}
				else if (curChoice == 3) {
					System.out.println("\nPrinting combined conference standings");
					//printResults(allTeamPCT);
					for (int x : sortedCombinedList(easternW, westernW)){System.out.println(x);}
				}
				curChoice = showMenu();
		
			}
		}	catch (Exception ex) {
			System.out.println("That is not a valid option");
		}
	}
	
}
