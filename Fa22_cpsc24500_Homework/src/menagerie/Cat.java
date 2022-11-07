package menagerie;

public class Cat extends Pet{

	public Cat(String n, double w, int a) {
		super(n, w, a);
	}

	@Override
	public String getType() {
		return "Cat";
	}
	
}
