package menagerie;

public abstract class Pet implements Comparable<Pet> {
	//abstract class pet that defines things that all pets have/do
	private String name;
	private double weight;
	private int age;
	
	public Pet(String n, double w, int a) {
		setName(n);
		setWeight(w);
		setAge(a);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract String getType();
	
	@Override
	public String toString() {
		return String.format("Name: %s, Weight: %s, Age: %s", name, weight, age);
	}
	@Override
	public int compareTo(Pet other) {
		//use Collections.sort
		return getName().compareTo(other.getName());
	}
	

}
