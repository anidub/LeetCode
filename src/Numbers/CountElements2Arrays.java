package Numbers;

import java.util.Arrays;
/*
 * https://www.geeksforgeeks.org/element-1st-array-count-elements-less-equal-2nd-array/
 * For each element in 1st array count elements less than or equal to it in 2nd array
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Source: Amazon Interview Experience | Set 354 (For SDE-2)

Examples:

Input : arr1[] = [1, 2, 3, 4, 7, 9]
        arr2[] = [0, 1, 2, 1, 1, 4]
Output : [4, 5, 5, 6, 6, 6]

Input : arr1[] = [5, 10, 2, 6, 1, 8, 6, 12]
        arr2[] = [6, 5, 11, 4, 2, 3, 7]
Output : [4, 6, 1, 5, 0, 6, 5, 7]
Time Complexity: O(mlogn + nlogn), 
 */
public class CountElements2Arrays {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 7, 9 };
		int arr2[] = { 0, 1, 2, 1, 1, 4 };
		countElements(arr1, arr2);
	}

	public static void countElements(int[] arr1, int[] arr2){
		if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0)
			return;
		Arrays.sort(arr2);
		for(int i = 0; i < arr1.length; i++){
			int index = getIndex(arr1[i], arr2, 0, arr2.length-1);
			System.out.print((index+1) + " ");
		}
	}
	
	public static int getIndex(int number, int[] arr, int low, int high){
		while(low <= high){
			int mid = low + (high-low)/2;
			if(number >= arr[mid]){
				low = mid+1;				
			}else{
				high = mid-1;
			}
		}
		return high;
	}
}
