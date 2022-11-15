package menagerie;

public class Fish extends Pet{
	
	//cutoff var's for the dogs tasks CO = cut off
		private int eatCO;
		private int sleepCO;
		private int attentCO;
		private int randTaskCO;
		
		public Fish(String name, int age, double weight) {
			super(name, age, weight);
			//the 3 cutoff numbers will be used as percentages to do that task
			setEatCO(10);
			setSleepCO(20);
			setAttentCO(35);
			setRandTaskCO(35);
		}
		public Fish(String name, int age, double weight, int eat, int sleep, int attent, int rand) {
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
		return "Fish";
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
			return String.format("The %s, %s, swam up to the top of the tank for food.", getType(), getName());
		}
		else if (num <= (getEatCO() + getSleepCO())){
			return String.format("The %s, %s, was sleepy and slept on the coral.", getType(), getName()); 
		}
		else if (num <= (getEatCO() + getSleepCO() + getAttentCO())) {
			return String.format("The %s, %s, looks like its drowning.", getType(), getName());	
		}
		else {
			//now to get a random task I check if the number is divisible by different numbers instead of making a new random
			if (num % 3 == 0) {
				return String.format("The %s, %s, hung out in the castle.", getType(), getName());
			}
			else if (num % 2 == 0){
				return String.format("The %s, %s, hung out in the castle.", getType(), getName());
			}
			else {
				return String.format("The %s, %s, did nothing.", getType(), getName());
			}
		}
	}
	
}
