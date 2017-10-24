package Numbers;

public class SurroundedRegion {
/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
http://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
https://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/
http://n00tc0d3r.blogspot.com/2013/06/surrounded-regions.html
http://liuhuac.github.io/post/Surrounded-Regions/
Time complexity : O(MN)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void solve(char[][] board) {
	    if(board == null || board.length==0) 
	        return;
	 
	    int m = board.length;
	    int n = board[0].length;
	 
	    //merge O's on left & right border
	    for(int i=0;i<m;i++){
	        if(board[i][0] == 'O'){
	        	markDFS(board, i, 0);
	        }	 
	        if(board[i][n-1] == 'O'){
	        	markDFS(board, i,n-1);
	        }
	    }
	 
	    //merge O's on top & bottom boarder
	    for(int j=0; j<n; j++){
	         if(board[0][j] == 'O'){
	        	 markDFS(board, 0,j);
	        }	 
	        if(board[m-1][j] == 'O'){
	        	markDFS(board, m-1,j);
	        }
	    }
	 
	    //process the board
	    for(int i=0;i<m;i++){
	        for(int j=0; j<n; j++){
	            if(board[i][j] == 'O'){
	                board[i][j] = 'X';
	            }else if(board[i][j] == '#'){
	                board[i][j] = 'O';
	            }
	        }
	    }
	}
	
	private void markDFS(char[][] board, int x, int y) {
		if (board[x][y] != 'O') {
			return;
		}
		// mark the current node
		board[x][y] = '#';
		// mark its neighbors if needed
		int rows = board.length, columns = board[0].length;
		if (x + 1 < rows - 1)
			markDFS(board, x + 1, y);
		if (x - 1 > 0)
			markDFS(board, x - 1, y);
		if (y + 1 < columns - 1)
			markDFS(board, x, y + 1);
		if (y - 1 > 0)
			markDFS(board, x, y - 1);
	} 
}
