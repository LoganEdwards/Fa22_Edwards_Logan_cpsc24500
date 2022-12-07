package quizzy;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class QuizzyFrame extends JFrame {
	private ArrayList<Question> questions;
	private QuizzyPanel qpan;
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(ArrayList<Question> qs) {
		questions = qs;
	}
	
	public void setupMenu() {
		setTitle("Drawing");
		setBounds(100,50,500,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		QuizzyPanel dp = new QuizzyPanel();
		c.add(dp,BorderLayout.CENTER);
		
		//create the buttons for the menu bar
		JMenuBar jmBar = new JMenuBar();
		setJMenuBar(jmBar);
		JMenu menuFile = new JMenu("File");
		jmBar.add(menuFile);
		JMenuItem menuLoad = new JMenuItem("Load Questions");
		menuFile.add(menuLoad);
		JMenuItem menuQuiz = new JMenuItem("Quiz");
		jmBar.add(menuQuiz);
		
		menuLoad.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JFileChooser fChooser = new JFileChooser();
					ArrayList<Question> newQuestions;
					if(fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						newQuestions = new QuizzyFileReader().readFromText(fChooser.getSelectedFile());
						if(newQuestions == null) {
							JOptionPane.showMessageDialog(null, "The questions could not be read from the file.");
						}
						else {
							questions = newQuestions;
							qpan.setQuestions(newQuestions);
							repaint();
						}
					
					
					}
					
					
				}
					
					
			}		
		);
		
	}
	
	public void setupGUI() {
		
	}
	
	public QuizzyFrame() {
		setupGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
