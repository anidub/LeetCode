package graph;

import java.util.Arrays;
import java.util.Iterator;
/*
 * Find a Mother Vertex in a Graph
What is a Mother Vertex?
A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.
How to find mother vertex?

Case 1:- Undirected Connected Graph : In this case, all the vertices are mother vertices as we can reach to all the other nodes in the graph.
Case 2:- Undirected/Directed Disconnected Graph : In this case, there is no mother vertices as we cannot reach to all the other nodes in the graph.
Case 3:- Directed Connected Graph : In this case, we have to find a vertex -v in the graph such that we can reach to all the other nodes in the graph through a directed path.
	
If there exist mother vertex (or vertices), then one of the mother vertices is the last finished vertex in DFS. (Or a mother vertex has the maximum finish time in DFS traversal).


  If there exist mother vertex (or vertices) in given graph, then v must be one (or one of them) Now check if v is actually a mother vertex (or graph
has a mother vertex).  We basically check if every vertex is reachable from v or not. 
 Reset all values in visited[] as false and do  DFS beginning from v to check if all vertices are reachable from it or not.
 * http://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
 * https://gist.github.com/anil477/fd51961490d4b57f3cc7d6c3e7834e88
 */
public class motherVertex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void dfsUtil(int i, Graph graph, boolean[] visited){
		visited[i] = true;
		Iterator it = graph.adj[i].listIterator();
		while(it.hasNext()){
			int n = (int)it.next();
			while(!visited[n]){
				dfsUtil(n,graph,visited);
			}
		}
	}
	public void findMotherVertex(Graph graph){
		boolean[] visited = new boolean[graph.V];
		int v = 0;
		for(int i = 0; i < graph.V; i++){
			if(!visited[i]){
				dfsUtil(i,graph,visited);
				v = i;
			}
		}
		
		Arrays.fill(visited, false);
		dfsUtil(v, graph, visited);
		for(int i = 0; i < graph.V; i++){
			if(!visited[i]){
				System.out.println("no mother index.Node that wasn't connected :" + i);
				return;
			}
		}
		System.out.println("mother index : " + v);		
	}
}