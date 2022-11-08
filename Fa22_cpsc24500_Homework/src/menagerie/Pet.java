package menagerie;

public abstract class Pet implements Comparable<Pet> {
	//abstract class pet that defines things that all pets have/do
	private String name;
	private double weight;
	private int age;
	
	public Pet(String n, int a, double w) {
		setName(n);
		setAge(a);
		setWeight(w);
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
		return String.format("Name: %s, Age: %s, Weight: %s", name, age, weight);
	}
	@Override
	public int compareTo(Pet other) {
		//use Collections.sort to sort the pets
		return getName().compareTo(other.getName());
	}
	

}
