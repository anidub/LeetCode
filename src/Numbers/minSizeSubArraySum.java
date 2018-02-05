package Numbers;

public class minSizeSubArraySum {
/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum >= s.
 *  If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
//https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59078/Accepted-clean-Java-O(n)-solution-(two-pointers)
 * O(n)
 */
	public static void main(String[] args) {
		int[] arr  = {2,3,1,2,4,3};
		int sum = 7;
		System.out.println(minSizeArray(sum, arr));
	}
	
	public static int minSizeArray(int sum, int[] array){
		int currentsum = 0;
		int start = 0; int minLength = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++){
			currentsum += array[i];
			while(currentsum >= sum){
				minLength = Math.min(minLength, i- start + 1);
				currentsum = currentsum - array[start];
				start++;
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

}
