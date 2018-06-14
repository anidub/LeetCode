package graph;

import java.util.Iterator;
import java.util.Stack;
/*
 * http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 *  time complexity : O(V + E).
 *  
 *  //Compare Matrix representation vs list representation
 */
public class IterativeDFS {
	
	public static void main(String[] args) {

	}
	
	public static void iterativedfs(Graph graph){
		int size = graph.V;//total vertices
		boolean[] visited = new boolean[size];
		for(int i = 0; i < size; i++){
			if(!visited[i])
				dfs(graph, i, visited);
		}
	} 
	
	public static void dfs(Graph graph, int i, boolean[] visited){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		
		while(!stack.isEmpty()){
			 i = stack.pop();
			if(!visited[i]){
				System.out.println(i);
				visited[i] = true;
			}
			Iterator it = graph.adj[i].listIterator();
			while(it.hasNext()){
				int k = (int)it.next();
				if(!visited[k]){
					stack.push(k);
				}
			}
		}
	}

}
