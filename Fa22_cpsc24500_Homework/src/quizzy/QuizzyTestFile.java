package quizzy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizzyTestFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuizzyFileReader qfr = new QuizzyFileReader();
		ArrayList<Question> questions = new ArrayList<Question>();
		String fName;
//		System.out.print("Enter the name of the file: ");
//		//fName = sc.next();
//		fName = "questions_with_e_for_all_answers.txt";
//		System.out.println(fName + "\n");
////		questions = qfr.readFromText(new File(fName));
//		for (int i = 0; i < questions.size(); i++) {
//			System.out.println(i+1 + ".\t" + questions.get(i).toString());
//			System.out.println(questions.get(i).getAnswer());
//		}
		QuizzyFrame qf = new QuizzyFrame();
		qf.setVisible(true);
	}
	
}
