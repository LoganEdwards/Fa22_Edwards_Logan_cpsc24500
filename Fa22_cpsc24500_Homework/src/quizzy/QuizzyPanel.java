package quizzy;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QuizzyPanel extends JPanel{

	private ArrayList<Question> questions;
	private Question curQuestion;
	private int index = 0;
	private String message;
	private JTextArea tarQuestion = new JTextArea();
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void incrementIndex() {
		index++;
	}
	public void showAnsWrong() {
		//g.drawString("The answer is wrong, the correct answer was " + questions.get(index).getAnswer(), 10, 300);
		repaint();
	}
	public void showAnsRight() {
		//g.drawString("Correct! the answer was " + questions.get(index).getAnswer(), 10, 300);
		repaint();
	}
	public boolean nextQuestion() {
		//returns true if there is another question after the current one
		if(questions.size() > index+1) {
			return true;
			
		}
		else {
			return false;
		}
	}
	public QuizzyPanel(ArrayList<Question> qs) {
		setQuestions(qs);
		tarQuestion.setText("Select File >> Load Questions to begin.");
	}
	public QuizzyPanel() {
		tarQuestion.setText("Select File >> Load Questions to begin.");
	}
	
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		if(questions != null) {
//			g.drawString(showQuestion(index), 10, 10);
//		}
//	}
	
	
	
	public String showQuestion(int index) {
		//this method just shortens down the amount of writing needed in paint component
		return questions.get(index).toString();
	}
	public void setQuestions(ArrayList<Question> qs) {
		questions = qs;
	}
	
}
