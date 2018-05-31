package Geometry;

public class FindAreaRectilinearRectangles {

	/*
	 * https://leetcode.com/problems/rectangle-area/description/
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure
	 * Calculate the area of each rectangle at first. Judge whether they have intersection.
	 *  If not, return the sum area of them. Otherwise, count the intersection area and subtract it by one time of total area.
	 *  
	 *  https://leetcode.com/problems/rectangle-area/discuss/62202/An-easy-to-understand-solution-in-JAVA
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static int getArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int rectOne = (C-A) * (D-B);
		int rectTwo = (G-E) * (H-F);
	
		if(A >= G || B >= H || C <= E || D <= F){
			return rectOne + rectTwo;
		}
		
		int length = Math.min(C, G) - Math.max(A, E);
		int height = Math.min(D, H) - Math.max(B, F);
		
		return rectOne + rectTwo - length * height;
	}

}
