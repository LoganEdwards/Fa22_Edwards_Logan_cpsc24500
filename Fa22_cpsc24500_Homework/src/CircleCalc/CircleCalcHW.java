//Logan Edwards

package CircleCalc;

import java.util.Random;

public class CircleCalcHW {
	
	public static void circumference(double r) {
		 //C = 2pi*r
		double circumf = 2* Math.PI * r;
		double roundedCircumf = (Math.round(circumf* 100))/100.0  ;
		
		System.out.println("Cicumference is  2 * 3.14 * " + r);
		System.out.println(" The answer is: " + circumf);
		System.out.println("Answer rounded to 2 decimal places = " + roundedCircumf + "\n");
	}
	
	public static void circArea(double r) {
		//A = pi*r^2
		double area = Math.PI * Math.pow(r, 2);
		double roundedArea = (Math.round(area * 100)) / 100.0;
		
		System.out.println("Area is: pi * " + r + "^2");
		System.out.println("The answer is: " + area);
		System.out.println("Answer rounded to 2 decimal places =  " + roundedArea + "\n");
	}
	
	public static void circleCalc(double r) {
		double radius = r;
		System.out.println("The radius is: " + radius + "\n");
		circumference(r);
		circArea(r);
		
	}
	
	public static void main(String[] args) {
		//double testRadius = 3.0;
		double randRadius = Math.round(Math.random() *(10) * 10) / 10.0;
		//Math.random generates (0.0 - 1.0) * 10 then rounded to 1 decimal place
		
		circleCalc(randRadius);
	}
	
}
