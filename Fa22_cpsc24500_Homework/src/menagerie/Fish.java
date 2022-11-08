package menagerie;

public class Fish extends Pet{

	public Fish(String n, int a, double w) {
		super(n, a, w);
	}

	@Override
	public String getType() {
		return "Fish";
	}

	
	
}
