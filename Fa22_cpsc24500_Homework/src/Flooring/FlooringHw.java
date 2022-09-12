package Flooring;

public class FlooringHw {
	
	public static double area(double l, double w) {
		return l * w;

	}
	public static double triangleArea(double base, double h) {
		double ans = 0.5 * base * h;
		ans = Math.floor(ans * 100) / 100.0;
		return ans;
	}
	
	public static void flooring() {
		/*price per package = 24.99 
		* 8 boards per package
		*/
		//finding area of left side
		double leftRect = area(25,7);
		double topRightRect = area(8,8);	
		double brTriangle = triangleArea((25-16), (15-7));
		double board = area(2, 0.5);
		
		double boardsInRects = (leftRect + topRightRect) / board;
		double boardsInTriangle = brTriangle / board;
		double totalBoards = boardsInRects + boardsInTriangle;
		
		if (totalBoards % 8 != 0) {
			totalBoards += totalBoards % 8;
		}
		System.out.println("The total number of boards rounded up to a multiple of 8: " + totalBoards);
		double totalPackages = totalBoards / 8;
		// add on extra 25%
		totalPackages *= 1.25;
		//round up for even # of packages
		totalPackages = Math.ceil(totalPackages);
		System.out.println("The total number of packages with the added 25% and rounded up to nearest whole number: " +
		totalPackages);
		//convert to price
		double price = totalPackages * 24.99;
		System.out.println("Total price for "+ (int)totalPackages + " is: " + price + "$");
		
	}
	
	public static void main(String[] args) {
		flooring();	
	}
	
	
}
