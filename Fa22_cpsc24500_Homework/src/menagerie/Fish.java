package menagerie;

public class Fish extends Pet{

	public Fish(String n, double w, int a) {
		super(n, w, a);
	}

	@Override
	public String getType() {
		return "Fish";
	}

	
	
}
