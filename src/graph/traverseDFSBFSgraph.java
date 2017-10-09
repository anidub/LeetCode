package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class traverseDFSBFSgraph {

	/*
	 * Applications of DFS : http://www.geeksforgeeks.org/applications-of-depth-first-search/
	 * Applications of BFS: http://www.geeksforgeeks.org/applications-of-breadth-first-traversal/
	 */
	public static void main(String[] args){
		Graph g = new Graph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        traverseDFS(g);
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        traverseBFS(2,g);
	}
	
//	/Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	public static void traverseDFS(Graph graph){
		int v = graph.V;
		boolean[] visited = new boolean[v];
		for(int i = 0; i < v; i++){
			if(visited[i] == false)
				traverse(i, graph, visited);
		}
	}
	
	public static void traverse(int v, Graph graph, boolean[] visited){
		visited[v] = true;
		System.out.println(v + " ");
		Iterator i = graph.adj[v].listIterator();
		while(i.hasNext()){
			int n = (int) i.next();
			if(!visited[n]){
				traverse(n, graph, visited);
			}
		}
	}
	
	//Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	public static void traverseBFS(int s, Graph graph){
		int v = graph.V;
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()){
			s = queue.poll();
			System.out.println(s + " ");
			Iterator i = graph.adj[s].listIterator();
			while(i.hasNext()){
				int n = (int)i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}
