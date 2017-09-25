package Numbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllSetsOf3Sum {
/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:[
  [-1, 0, 1],
  [-1, -1, 2]
]
https://leetcode.com/problems/3sum/discuss/
Concise O(N^2) Java solution
 */
	public static void main(String[] args) {
		int[] S = {-1, 0, 1, 2, -1, -4};
		threeSum(S);
		threeSumClosest(S,2);
	}	
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
	/*
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
	 *  Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 *  https://leetcode.com/problems/3sum-closest/description/
	 *  Java solution with O(n2) for reference
	 */
public static int threeSumClosest(int[] num, int target) {
	Arrays.sort(num);
    int result = Integer.MAX_VALUE; 
    for (int i = 0; i < num.length-2; i++) {
            int lo = i+1, hi = num.length-1;
            while (lo < hi) {
                int sum = num[i] + num[lo] + num[hi];
                if(sum < target){
                	lo++;
                }else{
                	hi--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
           }
        }
    System.out.println(result);
    return result;
    }
}