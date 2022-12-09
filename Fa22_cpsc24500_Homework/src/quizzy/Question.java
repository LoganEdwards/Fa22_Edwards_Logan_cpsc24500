package quizzy;

public class Question {
	
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private char answer;	
	
	public Question(String q, String a1, String a2, String a3, String a4, char ans) {
		//constructor for 4 questions
		setQuestion(q);
		setChoice1(a1);
		setChoice2(a2);
		setChoice3(a3);
		setChoice4(a4);
		setAnswer(ans);
	}
	public Question(String q, String a1, String a2, String a3, char ans) {
		//constructor for 3 questions
		setQuestion(q);
		setChoice1(a1);
		setChoice2(a2);
		setChoice3(a3);
		setChoice4(null);
		setAnswer(ans);
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		//print the neatly formatted string with answer choices
		//change the format to a 3 question format 
		if (choice4 == null) {
			return String.format("%s\n\ta.\t%s\n\tb.\t%s\n\tc.\t%s", getQuestion(),getChoice1(),getChoice2(),getChoice3());
			
		}
		//format for 4 questions
		return String.format("%s\n\ta.\t%s\n\tb.\t%s\n\tc.\t%s\n\td.\t%s", getQuestion(),getChoice1(),getChoice2(),getChoice3(),getChoice4());
	}
	
	public String toTabbedString() {
		return String.format("%s\t%s\t%s\t%s\t%s", getQuestion(),getChoice1(),getChoice2(),getChoice3(),getChoice4());
	}
	
}
