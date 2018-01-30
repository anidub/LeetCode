package Numbers;

import java.util.List;

public class TriangleMinSum {
/*
 * https://discuss.leetcode.com/topic/44676/java-solution-using-o-n-space-without-modify-triangle
 * https://leetcode.com/problems/triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Time complexity : O(n2)
Space complexity : O(n)
 */
	public static void main(String[] args) {


	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
	    int len = triangle.size();
	    int[] dp = new int[len];
	    for(int i = len-1;i >= 0; i--){
	        for(int j = 0; j <= i; j++){
	            if(i == len-1) dp[j]= triangle.get(i).get(j);
	            else{
	                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
	            }
	        }
	    }
	    return dp[0];
	} 
}
