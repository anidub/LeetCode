package graph;
/*
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem
 * Backtracking Algorithm
The idea is to place queens one by one in different columns, starting from the leftmost column. 
When we place a queen in a column, we check for clashes with already placed queens. In the current column,
 if we find a row for which there is no clash, we mark this row and column as part of the solution. 
 If we do not find such a row due to clashes then we backtrack and return false.
 Time complexity : O(N!)
  backtracking algorithm time complexity is exponential. 
 Space complexity : O ( N ^ 2)
 */
public class NQueenN {
	static int N = 4;
	public static void main(String[] args) {
		solveNQ();
	}
	
	public static void solveNQ(){
		int[][] board = {{0,0,0,0},
						 {0,0,0,0},
						 {0,0,0,0},
						 {0,0,0,0}};		
		if(solveNQUtil(board,0) == false){
			System.out.println("No solution");
		}else{
			print(board);
		}
	}
	
	public static boolean solveNQUtil(int[][] board, int col){
		if(col >= N) return true;
		for(int i = 0; i < N; i++){
			if(isSafe(board, i, col)){
				board[i][col] = 1;
				if(solveNQUtil(board, col+1) == true)
					return true;
				board[i][col] = 0;
			}			
		}
		return false;
	}
	
	public static boolean isSafe(int[][] board, int row, int col){
		int i,j;
		for(i = 0; i < col; i++){
			if(board[row][i] == 1)
				return false;
		}
		
		for(i = row, j = col; i >= 0 && j >= 0; i--,j--){
			if(board[i][j] == 1)
				return false;
		}
		
		for(i = row, j = col; j >= 0 && i < N; i++,j--){
			if(board[i][j] == 1)
				return false;
		}
		return true;
	}
	
	public static void print(int board[][]){
	        for (int i = 0; i < N; i++){
	            for (int j = 0; j < N; j++)
	                System.out.print(" " + board[i][j] + " ");
	            System.out.println();
	        }
	    }
}
