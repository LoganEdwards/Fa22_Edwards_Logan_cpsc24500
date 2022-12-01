package quizzy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizzyFileReader {
	
	public ArrayList<Question> readFromText(String fName){
		ArrayList<Question> qs = new ArrayList<Question>();
		String line = "";
		String[] parts;
		try {
			Scanner fsc = new Scanner(new File(fName));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				//Make a new question and pass in the question, ans1, ans2, ans3, ans4, and the real answer choice
				if(parts.length != 5)
					qs.add(new Question(parts[0], parts[1],parts[2],parts[3],parts[4], line.charAt(line.length()-1)));
				else {
					qs.add(new Question(parts[0], parts[1],parts[2],parts[3], line.charAt(line.length()-1)));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return qs;
	}
	
}
