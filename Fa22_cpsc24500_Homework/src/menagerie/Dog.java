package menagerie;

public class Dog extends Pet{
	
	//cutoff var's for the dogs tasks CO = cut off
	private int eatCO;
	private int sleepCO;
	private int attentCO;
	private int randTaskCO;
	
	public Dog(String name, int age, double weight) {
		super(name, age, weight);
		//the 4 cutoff numbers will be used as percentages to do that task
		setEatCO(20);
		setSleepCO(25);
		setAttentCO(40);
		setRandTaskCO(15);
	}
	public Dog(String name, int age, double weight, int eat, int sleep, int attent, int rand) {
		super(name, age, weight, eat, sleep, attent);
		setRandTaskCO(rand);
	}
	
	public int getEatCO() {
		return eatCO;
	}

	public void setEatCO(int eatCO) {
		this.eatCO = eatCO;
	}

	public int getSleepCO() {
		return sleepCO;
	}
	public void setSleepCO(int i) {
		sleepCO = i;
	}
	
	public int getAttentCO() {
		return attentCO;
	}
	public void setAttentCO(int attentCO) {
		this.attentCO = attentCO;
	}
	
	public int getRandTaskCO() {
		return randTaskCO;
	}
	public void setRandTaskCO(int randTaskCO) {
		this.randTaskCO = randTaskCO;
	}
	
	@Override
	public String getType() {
		return "Dog";
	}
	
	@Override
	public String toString() {
		//prints out the Name: name, Age: age, and Weight: weight
		return String.format("%s\t", getType()) + super.toString();	
	}
	
	
	@Override
	public String act(int num) {
		//checks if the num, which is a random num from the pet class, is within the percentage of the current task
		if (num <= getEatCO()) {
			return String.format("The %s, %s, went to eat some food", getType(), getName());
		}
		else if (num <= (getEatCO() + getSleepCO())){
			return String.format("The %s, %s, was sleepy and took a nap.", getType(), getName()); 
		}
		else if (num <= (getEatCO() + getSleepCO() + getAttentCO())) {
			return String.format("The %s, %s, sought your attention", getType(), getName());	
		}
		else {
			//now to get a random task I check if the number is divisible by different numbers instead of making a new random
			if (num % 3 == 0) {
				return String.format("The %s, %s, whimpered at its water bowl", getType(), getName());
			}
			else if (num % 2 == 0){
				return String.format("The %s, %s, barked at the window", getType(), getName());
			}
			else {
				return String.format("The %s, %s, did nothing", getType(), getName());
			}
		}
	}
	
}
