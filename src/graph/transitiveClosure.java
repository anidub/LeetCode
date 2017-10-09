package graph;

import java.util.Iterator;
/*
 * http://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 * TIme complexity : O(V2) algorithm
 * Given a directed graph, find out if a vertex v is reachable from another vertex u for all vertex pairs (u, v) in the given graph. 
 * Here reachable mean that there is a path from vertex u to v. 
 * The reach-ability matrix is called transitive closure of a graph.
 * Transitive closure of above graphs is 
     1 1 1 1 
     1 1 1 1 
     1 1 1 1 
     0 0 0 1 
 */
public class transitiveClosure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public void dfsUtil(boolean[][] matrix, int s, int v,Graph graph){
		matrix[s][v] = true;
		Iterator it = 	graph.adj[v].listIterator();
		while(it.hasNext()){
			int n = (int)it.next();
			if(!matrix[s][n]){
				dfsUtil(matrix,s,n,graph);
			}
		}
	}
	public void transitiveClosure(Graph graph){
		boolean[][] matrix = new boolean[graph.V][graph.V];
		
		for(int i = 0; i < graph.V; i++){
			dfsUtil(matrix,i,i,graph);
		}
		
		for (int i = 0; i < graph.V; i++) {
			for (int j = 0; j < graph.V; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
