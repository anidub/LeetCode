package Numbers;

import java.util.ArrayList;
import java.util.HashSet;
/*
 * https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C++Java-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class FindNumberRepeatedTwice {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,3,5,5,6};
		repeatNumbersTwice(arr);

	}
	
	public static ArrayList<Integer> repeatedNumbersTwice(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i : arr){
			if(set.contains(i)){
				result.add(i);
			}else{
				set.add(i);
			}			
		}
		return result;
	}
	
	//NOT working! but this is an accepted solution
	//https://leetcode.com/problems/single-number-iii/discuss/68922/A-summary-of-Java-solutions
	public static int[] repeatNumbersTwice(int[] arr){
		int diff = 0;
		for(int i : arr){
			diff ^= i;
		}
		int[] result ={0,0};
		
		diff &= -diff;
		
		for(int i : arr){
			if((i & diff) == 0)
				result[0] ^= i;
			else
				result[1] ^= i;
		}
		return result;
	}
}
