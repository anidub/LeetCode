package Numbers;

import java.util.TreeSet;
/*
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the 
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * https://leetcode.com/problems/contains-duplicate-iii/discuss/61655/Java-O(N-lg-K)-solution
 * Time complexity : O(N log K) 
 */
public class DifferentNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean ifExists(int[] nums, int k, int t){
		if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0; i < nums.length; i++){
			Integer floor = set.floor(nums[i] + t);
			Integer ceil = set.ceiling(nums[i] - t);
			
			if((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])){
				return true;
			}
			set.add(nums[i]);
			if(i >= k){
				set.remove(nums[i-k]);
			}			
		}
		return false;
	}
}
