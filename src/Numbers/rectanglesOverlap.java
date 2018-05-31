package Numbers;

public class rectanglesOverlap {
/*
 * Find if two rectangles overlap
Given two rectangles, find if the given two rectangles overlap or not.

Note that a rectangle can be represented by two coordinates, top left and bottom right. So mainly we are given following four coordinates.
l1: Top Left coordinate of first rectangle.
r1: Bottom Right coordinate of first rectangle.
l2: Top Left coordinate of second rectangle.
r2: Bottom Right coordinate of second rectangle

Time complexity : O(1)

http://www.geeksforgeeks.org/find-two-rectangles-overlap/
 */
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean doOverLap(Point l1, Point r1, Point l2, Point r2){
		//top case
		if(r2.y > l1.y || l2.y < r1.y) 
			return false;
		
		//left case
		if(r2.x < l1.x || l2.x > r1.x)
			return false;
		
		return true;
	}

}
