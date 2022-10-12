package wnbastats;

import java.io.File;

public class WNBAStats {
	//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
	//open file
	//read every line in file
	//		if its a conference line,
	/*
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
	 * 			parts[0] is name
	 * 			parts[1] is wins
	 * 			parts[2] is loss
	 * 			compute pct and gb
	 * 			print the teams info
	 */
	
	public static void main(String[] args) {
		String[] eastern = new String[6];
		String[] western = new String[6];
		
		try { 
			File wnbaInfo1 = new File("wnba.txt");
			
			
		} catch (Exception ex ) {
			
		}
		
		
	}
	
}
