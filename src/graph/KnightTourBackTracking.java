package graph;
/*
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * Problems which are typically solved using backtracking technique have following property in common. 
 * These problems can only be solved by trying every possible configuration and each configuration is tried only once.
 *  A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. 
 * Backtracking works in incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.
 * The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.
 * Time complexity : 8^(n^2-1)
 */
public class KnightTourBackTracking {
static int N = 8;
	public static void main(String[] args) {
		solveKT();
	}	
	
	public static boolean isSafe(int x, int y, int[][] sol){
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}
	
	public static boolean solveKT(){
		int[][] sol = new int[8][8];
		for(int i = 0; i < sol.length; i++){
			for(int j = 0; j < sol[i].length; j++){
				sol[i][j] = -1;
			}
		}
		
		/* xMove[] and yMove[] define next move of Knight.
        xMove[] is for next value of x coordinate
        yMove[] is for next value of y coordinate */
      int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
      int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
	
      // Since the Knight is initially at the first block
      sol[0][0] = 0;
      
      /* Start from 0,0 and explore all tours using solveKTUtil() */
      if(solveKTUtil(0,0,1,sol,xMove,yMove) == false){
    	  System.out.println("soln doest exits");
    	  return false;
      }else{
    	  print(sol);
    	  return true;
      }
	}
	
	/* Try all next moves from the current coordinate  x, y */
	public static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] xmove, int[] ymove){
		int k,x_next,y_next;
		
		if(movei == N * N) return true;
		
		for(k = 0; k < N; k++){
			x_next = x + xmove[k];
			y_next = y + ymove[k];
			
			if(isSafe(x_next, y_next,sol)){
				sol[x_next][y_next] = movei;
				if(solveKTUtil(x_next, y_next, movei+1, sol, xmove, ymove))
					return true;
				else
					sol[x_next][y_next] = -1;//// backtracking
			}
		}
		return false;
	}
	
	public static void print(int[][] sol){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

}
