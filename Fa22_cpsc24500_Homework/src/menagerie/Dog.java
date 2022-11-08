package menagerie;

public class Dog extends Pet{

	public Dog(String name, int age, double weight) {
		super(name, age, weight);
		
	}

	@Override
	public String getType() {
		return "Dog";
	}
	
//	@Override
//	public String toString() {
//		return super.toString();	
//	}
}
