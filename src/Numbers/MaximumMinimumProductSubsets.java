package Numbers;
/*
 * Maximum and Minimum Product Subsets
Given a set, we need to find maximum and minimum possible product among all subsets of the set.
Examples:

Input : arr[] = {4, -2, 5};
Output: Maximum product = 20 
        Minimum product = -40
Maximum product is obtained by multiplying
4 5
Minimum product is obtained by multiplying 
4, -2, 5
http://www.geeksforgeeks.org/maximum-and-minimum-product-subsets-with-one-product-covering-all-elements/
Time complexity :O(N)
 */
public class MaximumMinimumProductSubsets {

	static class MaxMin{
		int max;
		int min;
		
		public MaxMin(int max, int min){
			this.max = max;
			this.min = min;
		}
	}
	public static void main(String[] args) {
		int arr[] = {-4, -2, 3, 7, 5, 0, 1};
		MaxMin result = getProduct(arr);
		System.out.println("max :" + result.max +" min :" + result.min);
	}
	
	public static MaxMin getProduct(int[] arr) {
		MaxMin result = null;
		if (arr == null || arr.length == 0)
			return null;
		if (arr.length == 1) {
			result.max = arr[0];
			result.min = arr[0];
			return result;
		}
		
		int curMax = arr[0]; int curMin = arr[0];
		int prevMax = arr[0]; int prevMin = arr[0];
		int max = arr[0]; int min = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			 /* Current maximum product is maximum of following
            1) prevMax * curElement (when curElement is +ve)
            2) prevMin * curElement (when curElement is -ve)
            3) Element itself
            4) Previous max product */
			curMax = Math.max(prevMax * arr[i], Math.max(prevMin * arr[i], arr[i]));
			curMax = Math.max(prevMax, curMax);
			
			curMin = Math.min(prevMax * arr[i], Math.min(prevMin * arr[i], arr[i]));
			curMin = Math.min(prevMin, curMin);
			
			max = Math.max(max, curMax);
			min = Math.min(min, curMin);
			
			prevMax = curMax;
			prevMin = curMin;
		}
		result = new MaxMin(max, min);
		return result;
	}
}
