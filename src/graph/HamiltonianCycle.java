package graph;
/*
 * http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. A Hamiltonian cycle (or Hamiltonian circuit)
 *  is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path.
 *  
 *  Backtracking Algorithm
Create an empty path array and add vertex 0 to it. Add other vertices, starting from the vertex 1.
 Before adding a vertex, check for whether it is adjacent to the previously added vertex and not already added. 
If we find such a vertex, we add the vertex as part of the solution. If we do not find a vertex then we return false.

Time complexity :  O(n!)
 */
public class HamiltonianCycle {
	static int V = 5;
	public static void main(String[] args) {
		 int graph1[][] = {{0, 1, 0, 1, 0},
		            {1, 0, 1, 1, 1},
		            {0, 1, 0, 0, 1},
		            {1, 1, 0, 0, 1},
		            {0, 1, 1, 1, 0},
		        };
		 
		        // Print the solution
		 hamiltonianCycle(graph1);
	}
	
	public static void hamiltonianCycle(int[][] graph){
		int[] path = new int[V];
		
		for(int i = 0; i < V; i++){
			path[i] = -1;
		}
		path[0] = 0;//path[0] = s; s -> source
		
		if(solveHamiltonianCycleUtil(graph, path, 1) == false){
			System.out.println("No soltuion exist");
		}else{
			printSolution(path);
		}
	}
	
	public static boolean isSafe(int v, int[][] graph, int[] path, int pos){
		 /* Check if this vertex is an adjacent vertex of the previously added vertex. */
		if(graph[path[pos-1]][v] == 0)
			return false;
		
		 /* Check if the vertex has already been included.This step can be optimized by creating an array of size V */
		for(int i = 0; i < pos; i++){
			if(path[i] == v)
				return false;
		}
		return true;
	}
	
	public static boolean solveHamiltonianCycleUtil(int[][] graph, int[] path, int pos){
		/* base case: If all vertices are included in Hamiltonian Cycle */
		if(pos == V){
			// And if there is an edge from the last included vertex to the first vertex
			if(graph[path[pos-1]][path[0]] == 1)
				return true;
			else
				return false;
		}
		for(int v = 1; v < V; v++){
			  /* Check if this vertex can be added to Hamiltonian Cycle */
			if(isSafe(v, graph, path, pos)){
				path[pos] = v;
				/* recur to construct rest of the path */
				if(solveHamiltonianCycleUtil(graph, path, pos+1))
					return true;
				/* If adding vertex v doesn't lead to a solution, then remove it */
				path[pos] = -1;
			}
		}
		return false;
	}
	
	public static void printSolution(int path[]) {
		System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
		for (int i = 0; i < V; i++)
			System.out.print(" " + path[i] + " ");

		// Let us print the first vertex again to show the complete cycle
		System.out.println(" " + path[0] + " ");
	}
}
