package Numbers;

import java.util.Arrays;
/*
 * Count the number of possible triangles
Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as three sides of triangles.
 For a triangle to be possible from 3 values, the sum of any two values (or sides) must be greater than the third value (or third side).
For example, if the input array is {4, 6, 3, 7}, the output should be 3. There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
 Note that {3, 4, 7} is not a possible triangle.
 http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 Time Complexity: O(n^2). 
 */
public class countTriangles {

	public static void main(String[] args) {
		 int arr[] = {10, 21, 22, 100, 101, 200, 300};
	     System.out.println("Total number of triangles is " + findNumberOfTriangles(arr));
	}
	
	public static int findNumberOfTriangles(int[] arr){
		Arrays.sort(arr);
		int count = 0;
		for(int i = arr.length - 1; i >= 0; i--){
			int start = 0;
			int end = i-1;
			while(start < end){
				if(arr[i] >= arr[start] + arr[end])
					start++;
				else{
					count += end - start;
					end--;
				}
			}
		}
		return count;
	}
}