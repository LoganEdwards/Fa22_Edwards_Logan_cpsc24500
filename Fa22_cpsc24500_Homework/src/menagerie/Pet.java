package menagerie;

import java.util.Random;

public abstract class Pet implements Comparable<Pet> {
	//abstract class pet that defines things that all pets have/do
	private String name;
	private double weight;
	private int age;
	private int eat;
	private int sleep;
	private int seekAttention;
	
	public Pet(String n, int a, double w) {
		setName(n);
		setAge(a);
		setWeight(w);
	}
	
	public Pet(String n, int a, double w, int eat, int sleep, int attent) {
		setName(n);
		setAge(a);
		setWeight(w);
		setEat(eat);
		setSleep(sleep);
		setSeekAttention(attent);
	}
	
	public int getSeekAttention() {
		return seekAttention;
	}

	public void setSeekAttention(int seekAttention) {
		this.seekAttention = seekAttention;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public int getEat() {
		return eat;
	}

	public void setEat(int eat) {
		this.eat = eat;
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
	public abstract String act(int num);
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s", name, age, weight);
	}
	@Override
	public int compareTo(Pet other) {
		//use Collections.sort to sort the pets
		return getName().compareTo(other.getName());
	}
	
	public int getRand() {
		//this random number will be passed into the cutoffs that are assigned in the specific pet constructors
		Random rnd = new Random();
		//makes a number from 0 - 99 and adds 1 so it is 1 - 100
		return rnd.nextInt(100) + 1;
	}
	

}
