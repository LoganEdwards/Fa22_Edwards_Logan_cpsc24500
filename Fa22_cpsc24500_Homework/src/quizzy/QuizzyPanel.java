package quizzy;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class QuizzyPanel extends JPanel{

	private ArrayList<Question> questions;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void showQuestion(int index) {
		questions.get(index).toString();
	}
	public void setQuestions(ArrayList<Question> qs) {
		questions = qs;
	}
	
}
