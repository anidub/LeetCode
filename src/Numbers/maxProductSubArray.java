package Numbers;

public class maxProductSubArray {
/*
 * Given an array that contains both positive and negative integers,
 *  find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.
 *  Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}
http://www.geeksforgeeks.org/maximum-product-subarray/
Time Complexity: O(n)
Auxiliary Space: O(1)
 */
	public static void main(String[] args) {
		//int arr[] = {-1, -2, -3, 4};
		int arr[] = {6, -3, -10, 0, 2};
        System.out.println("Maximum Sub array product is "+ getMax(arr));
	}
	
	//USE this!!!!
	// try and under max min product subsets in this package
	public static int getMax(int[] arrr){
		if(arrr.length == 0) return 0;
		int[] arr = {6,3,0,10,0,2}; 
		int result = arr[0]; int max = arr[0]; int min = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			int temp = max;
			
			max = Math.max(Math.max(max * arr[i], min * arr[i]), arr[i]);
			min = Math.min(Math.min(temp * arr[i], min * arr[i]), arr[i]);
			
			if(result < max){
				result = max;
			}
		}
		// if only positive numbers
		for(int i = 1; i < arr.length; i++){			
			max = Math.max(max * arr[i],  arr[i]);
			
			if(result < max){
				result = max;
			}
		}
		
		return result;
	}
	/*
	 *  assumes that the given input array always has a positive output.
	 *  It doesn’t work for arrays like {0, 0, -20, 0}, {0, 0, 0}.. etc. The solution can be easily modified to handle this case.
	 */
	public static int getMaxProductSubArray(int[] arr){
		int result = 1;
		int maxCurrent = 1;
		int minCurrent = 1;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > 0){
				maxCurrent = maxCurrent * arr[i];
				minCurrent = Math.min(minCurrent * arr[i], 1);
			}else if(arr[i] == 0){
				maxCurrent = 1;
				minCurrent = 1;
			}else{
				int temp = maxCurrent;
				maxCurrent = Math.max(minCurrent * arr[i],1);
				minCurrent = temp * arr[i];
			}
			
			if(result < maxCurrent){
				result = maxCurrent;
			}
		}
		return result;
	}
	
	/*
	 * https://leetcode.com/problems/maximum-product-subarray/discuss/
	 * O(n)
	 */
	public static int getMaxProduct(int[] arr){
		int result = arr[0];
		for(int i = 1, imax = result, imin = result; i < arr.length; i++){
			 // multiplied by a negative makes big number smaller, small number bigger so we redefine the extremums by swapping them
			if(arr[i] < 0)
				swap(imax, imin);
			
			// max/min product for the current number is either the current number itself or the max/min by the previous number times the current one
			imax = Math.max(imax, arr[i] * imax);
			imin = Math.min(imin, arr[i] * imin);
			
			result = Math.max(result, imax);
		}
		return result;
	}
	
	public static void swap(int imax, int imin){
		int temp = imax;
		imax = imin;
		imin = temp;
	}
}
