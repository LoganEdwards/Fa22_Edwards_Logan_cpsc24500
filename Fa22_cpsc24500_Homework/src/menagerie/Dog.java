package menagerie;

public class Dog extends Pet{

	public Dog(String name, double weight, int age) {
		super(name, weight, age);
		
	}

	@Override
	public String getType() {
		return "Dog";
	}
	
	
	
}
