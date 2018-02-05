package Numbers;

public class BiggestSquare {
/*
 * https://leetcode.com/problems/maximal-square/description/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
https://leetcode.com/problems/maximal-square/discuss/61876/Accepted-clean-Java-DP-solution

Time complexity :  O(n^2)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int biggestSquare(char[][] a){
		if(a.length == 0) return 0;
		int result = 0;
		int m = a.length; int n = a[0].length;
		
  // dp(i, j) represents the length of the square  whose lower-right corner is located at (i, j) dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(a[i-1][j-1] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]) + 1;
					result = Math.max(dp[i][j], result);
				}
			}
		}
		return result * result;
	}
 }
