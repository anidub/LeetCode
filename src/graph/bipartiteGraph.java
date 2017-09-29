package graph;

import java.util.LinkedList;
/*
 * Check whether a given graph is Bipartite or not
A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge (u, v) 
either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, 
or u belongs to V and v to U. We can also say that there is no edge that connects vertices of same set.
http://www.geeksforgeeks.org/bipartite-graph/
Use the vertex colouring algorithm:

1) Colour any one of your vertices red.

2) Identify all uncoloured vertices that are adjacent to a red vertex. Colour them blue.

3) Identify all uncoloured vertices that are adjacent to a blue vertex. Colour them red.

4) Repeat steps 2 and 3 until all the vertices are coloured red or blue.

5) If there are any two vertices adjacent of the same colour, then your graph is not bipartite, otherwise it is bipartite.

6) If the graph is bipartite, the colouring algorithm will have created the two required sets of points (one red and one blue).
https://math.stackexchange.com/questions/1477648/how-to-tell-if-a-graph-is-bipartite
To check whether a graph is bipartite or not is actually the same as checking whether it has an odd-lengthed cycle.

You can start a bfs from node 1 for example, and assume it is on the left side. Now all its neighbours must be on the right side. 
To check whether a graph is bipartite or not is actually the same as checking whether it has an odd-lengthed cycle.

You can start a bfs from node 1 for example, and assume it is on the left side. Now all its neighbours must be on the right side. 
In general, when the bfs reaches a node, you go through its neighbours and check if any of them is already visited and on the same side as your node is. 
Then, the graph is not bipartite. 
If you reach the end of the bfs with no errors, then the graph is bipartiteIn general, when the bfs reaches a node, you go through
 its neighbours and check if any of them is already visited and on the same side as your node is. 
Then, the graph is not bipartite. If you reach the end of the bfs with no errors, then the graph is bipartite

Connected is usually associated with undirected graph which there is a path between every two nodes.
 Whereas, Strongly connected is associated to directed graph which means there is route between every pair of vertices.

http://www.geeksforgeeks.org/bipartite-graph/
Time Complexity of the above approach is same as that Breadth First Search. In above implementation is O(V^2) where V is number of vertices.
 If graph is represented using adjacency list, then the complexity becomes O(V+E).
 */
public class bipartiteGraph {
	static int V = 4;
	public static void main(String[] args) {
		int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
                 
          if (isBiPartite(G))
             System.out.println("Yes");
          else
             System.out.println("No");

	}
	
	public static boolean isBiPartite(int[][] graph){
		int[] colorArr = new int[V];
		for(int i = 0; i < V; i++){
			colorArr[i] = -1;
		}
		
		for(int i = 0; i < V; i++){
			if(colorArr[i] == -1){
				if(isBiPartiteUtil(graph, i, colorArr) == false)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isBiPartiteUtil(int[][] graph, int source, int[] colorArr){
		colorArr[source] = 1;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		while(!queue.isEmpty()){
			int u = queue.poll();
			if(graph[u][u] == 1) return false;
			
			for(int v = 0; v < V; v++){
				if(graph[u][v] == 1 && colorArr[v] == -1){
					colorArr[v] = 1 - colorArr[u];
					queue.push(v);
				}else if(graph[u][v] == 1 && colorArr[v] == colorArr[u])
					return false;
			}			
		}
		return true;
	}

}
