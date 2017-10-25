package Numbers;

public class findPeakElement {
/*
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element. 
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. Note that we need to return any one peak element.
 * 
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/	
 * https://leetcode.com/problems/find-peak-element/description/
 * 
 * Time Complexity: O(Logn)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findPeak(int[] arr){
		return findPeakIndexUtil(arr, 0, arr.length-1);
	}
	
	public static int findPeakIndexUtil(int[] arr, int low, int high){
		int mid = low + (high-low)/2;
		
		if( (mid == 0 || arr[mid] >= arr[mid+1]) && (mid == arr.length-1 && arr[mid] >= arr[mid-1]) )
			return mid;
		else if( mid > 0 && arr[mid] < arr[mid-1])
			return findPeakIndexUtil(arr, low, mid-1);
		else
			return findPeakIndexUtil(arr, mid+1, high);
	}

}
