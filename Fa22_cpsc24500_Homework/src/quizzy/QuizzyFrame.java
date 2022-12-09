package quizzy;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizzyFrame extends JFrame {
	private JTextArea tarQuestion;
	private ArrayList<Question> questions;
	private char guess;
	private int score = 0;
	private int answered = 0;
	private int questionIndex;
	
	public char getGuess() {
		return guess;
	}
	public void setGuess(char c) {
		guess = c;
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(ArrayList<Question> qs) {
		questions = qs;
	}
	
	public void setupMenu() {
		setTitle("Object-Oriented Quiz Tool");
		setBounds(100,50,750,300);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		tarQuestion.setText("Welcome to Quizzy, the object-oriented programming quiz tool.\nSelectFile >> Load Questions to begin.");	
		//create the buttons for the menu bar
		JMenuBar jmBar = new JMenuBar();
		setJMenuBar(jmBar);
		JMenu menuFile = new JMenu("File");
		jmBar.add(menuFile);
		JMenuItem menuLoad = new JMenuItem("Load Questions");
		menuFile.add(menuLoad);
		JMenuItem menuQuiz = new JMenu("Quiz");
		jmBar.add(menuQuiz);
		JMenuItem quizStart = new JMenuItem("Start");
		menuQuiz.add(quizStart);
		JMenuItem menuExit = new JMenuItem("Exit");
		menuFile.add(menuExit);
		JMenuItem btnStop = new JMenuItem("Stop");
	    menuQuiz.add(btnStop);
	    
		menuLoad.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//setup button and allow the user to select a file for the questions 
					JFileChooser fChooser = new JFileChooser();
					ArrayList<Question> newQuestions;
					if(fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						newQuestions = new QuizzyFileReader().readFromText(fChooser.getSelectedFile());
						if(newQuestions == null) {
							JOptionPane.showMessageDialog(null, "The questions could not be read from the file.");
						}
						else {
							questions = newQuestions;
							tarQuestion.setText("The questions have been read. Select Quiz >> Start to begin");
						}
					}
				}
									
			}		
		);
		quizStart.addActionListener(
				//setup button to start the quiz and load first question
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						questionIndex = 0;
						tarQuestion.setText(questions.get(questionIndex).toString());
					}
				}
		);
		
		btnStop.addActionListener(
				new ActionListener() {
					//show score and close window
					public void actionPerformed(ActionEvent e) {
						completeQuiz();
						System.exit(ABORT);
					}
				}
				);
		
		
		menuExit.addActionListener(
			new ActionListener() {
				//button to close window
				public void actionPerformed(ActionEvent e) {
					System.exit(ABORT);
				}
			}
		);
		
	}
	
	public void setupGUI() {
		tarQuestion = new JTextArea();
		setBounds(100, 100, 400, 700);
	    setTitle("Object-Oriented Quiz Tool");
	    setupMenu();
	    Container c = getContentPane();
	    c.setLayout(new BorderLayout());
	    c.add(tarQuestion);
	    QuizzyPanel panSouth = new QuizzyPanel();
	    JLabel lblSize = new JLabel("Answer");
	    JTextField txtSize = new JTextField(3);
	    JButton btnSubmit = new JButton("Submit Answer");
	    JButton btnNext = new JButton("Next Question");
	    btnSubmit.setEnabled(true);
	    btnNext.setEnabled(false);
	    //tarQuestion = new JTextArea();
	    
	    btnSubmit.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        try {
	                        	repaint();
	                            String ans = txtSize.getText();
	                            if (ans.equalsIgnoreCase(String.valueOf(questions.get(questionIndex).getAnswer()))) {
	                                tarQuestion.setText(tarQuestion.getText() +String.format("\nCorrect. The correct answer is %s", questions.get(questionIndex).getAnswer()));
	                                score++;
	                            } else {
	                            	tarQuestion.setText(tarQuestion.getText() + String.format("\nIncorrect. The correct answer is %s", questions.get(questionIndex).getAnswer()));
	                            	guess = ans.charAt(0);	                            	
	                            }
	                            btnSubmit.setEnabled(false);
	                            btnNext.setEnabled(true);
	                            answered++;
	                        } catch (Exception ex) {
	                            JOptionPane.showMessageDialog(null, "The answer needs to be a, b, c, or d");
	                        }
	                        repaint();
	                    }
	                }
	        );
	        btnNext.addActionListener(
	        		new ActionListener() {
	        			public void actionPerformed(ActionEvent e) {
	        				repaint();
	        				if(questionIndex < questions.size()-1) {
	        					//if there is more questions set text area to the next question
	        					questionIndex++;
	        					tarQuestion.setText(questions.get(questionIndex).toString());
	        					btnSubmit.setEnabled(true);
	        					btnNext.setEnabled(false);
	        				}
	        				else {
	        					//no more questions then disable buttons and exit
	        					btnNext.setEnabled(false);
	        					btnSubmit.setEnabled(false);
	        					completeQuiz();
	        				}
	        				repaint();
	        			}
	        			
	        		}
	        			
	        );
	        panSouth.setLayout(new FlowLayout());
	        panSouth.add(lblSize);
	        panSouth.add(txtSize);
	        panSouth.add(btnSubmit);
	        panSouth.add(btnNext);
	        
	        c.add(panSouth,BorderLayout.SOUTH);
	        
	        //check if there is something in the answer box, if so don't grey out btn
	}
	
	public void completeQuiz() {
		//this methods purpose is to return the score and turn off the buttons on the quiz
		JOptionPane.showMessageDialog(null, String.format("You answered %d out of %d correctly"
				+ "\nThis is a percent score of %.2f.", score, answered,((double)score/answered)*100));
	}
	
	public QuizzyFrame() {
		setupGUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
