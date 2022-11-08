package menagerie;

public class Cat extends Pet{

	public Cat(String n, int a, double w) {
		super(n, a, w);
	}

	@Override
	public String getType() {
		return "Cat";
	}
	
}
