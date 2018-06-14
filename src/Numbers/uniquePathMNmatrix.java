package Numbers;
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
 Time complexity : O(n*m)
 USE THIS
 */
public class uniquePathMNmatrix {
		//total unique paths
	  public int uniquePaths(int m, int n) {
	        Integer[][] map = new Integer[m][n];
	        for(int i = 0; i<m;i++){
	            map[i][0] = 1;
	        }
	        for(int j= 0;j<n;j++){
	            map[0][j]=1;
	        }
	        for(int i = 1;i<m;i++){
	            for(int j = 1;j<n;j++){
	                map[i][j] = map[i-1][j]+map[i][j-1];
	            }
	        }
	        return map[m-1][n-1];
	    }
	  
	  /**
	 * Count all paths in matrix from source to destination
	 */
	static int findWays4directions( int[][] a, int i, int j, boolean[][] visited ) {
		    if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
		        return 0;

		    if ( i == a.length - 1 && j == a[0].length - 1 )
		        return 1;

		    if ( visited[i][j] == true )
		        return 0;

		    visited[i][j] = true;

		    int right = findWays4directions( a, i, j + 1, visited );
		    int down = findWays4directions( a, i + 1, j, visited );
		    int left = findWays4directions( a, i, j - 1, visited );
		    int up = findWays4directions( a, i - 1, j, visited );

		    visited[i][j] = false;

		    return left + down + right + up;
		}
	  
	  //obstacles
	  /*
	   * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
	   */
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        int[][] dp = new int[m][n];
	        for(int i = 0; i < m; i ++) {
	            if(obstacleGrid[i][0] == 1) {
	                dp[i][0] = 0;
	                break;
	            } else {
	                dp[i][0] = 1;
	            }
	        }
	        
	        for(int j = 0; j < n; j++) {
	            if(obstacleGrid[0][j] == 1) {
	                dp[0][j] = 0;
	                break;
	            } else {
	                dp[0][j] = 1;
	            }
	        }
	        
	        for(int i = 1; i < m; i ++) {
	            for(int j = 1; j < n; j ++) {
	                if(obstacleGrid[i][j] == 1) {
	                    dp[i][j] = 0;
	                } else {
	                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	                }
	            }
	        }
	        return dp[m - 1][n - 1];
	    }
}
