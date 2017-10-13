package graph;
/*
 * The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST,
 *  the other set contains the vertices not yet included. At every step,it considers all the edges that connect the two sets, 
 *  and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST.
A group of edges that connects two set of vertices in a graph is called cut in graph theory. So, at every step of Prim’s algorithm,
 we find a cut (of two sets, one contains the vertices already included in MST and other contains rest of the verices),
  pick the minimum weight edge from the cut and include this vertex to MST Set (the set that contains already included vertices).
  
How does Prim’s Algorithm Work? The idea behind Prim’s algorithm is simple, a spanning tree means all vertices must be connected. 
So the two disjoint subsets (discussed above) of vertices must be connected to make a Spanning Tree. 
And they must be connected with the minimum weight edge to make it a Minimum Spanning Tree.

http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/

Time Complexity of the above program is O(V^2). If the input graph is represented using adjacency list, 
then the time complexity of Prim’s algorithm can be reduced to O(E log V) with the help of binary heap.

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, 
edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge 

https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/

What is a Spanning Tree?

Given an undirected and connected graph G=(V,E),
 a spanning tree of the graph G is a tree that spans G (that is, it includes every vertex of G) and is a subgraph of G (every edge in the tree belongs to G)
 
 What is a Minimum Spanning Tree?

The cost of the spanning tree is the sum of the weights of all the edges in the tree. There can be many spanning trees. 
Minimum spanning tree is the spanning tree where the cost is minimum among all the spanning trees.

Explanation : https://www.youtube.com/watch?v=PzznKcMyu0Y
 */
public class MinimumSpanningTreePrim {
	private static int V = 5;
	public static void main(String[] args) {

	}
	
	public static void minimumSpanningTree(int[][] graph){
		int[] parent = new int[V];// Array to store constructed MST
		int[] key = new int[V];// Key values used to pick minimum weight edge in cut
		boolean[] mstSet = new boolean[V];  // To represent set of vertices not yet included in MST
		
		for(int v = 0; v < V; v++){
			key[v] = Integer.MAX_VALUE;
			mstSet[v] = false;
		}
		parent[0] = -1; // First node is always root of MST
		key[0] = 0;
		
		for(int count = 0; count < V-1; count++){
			int u = minKey(key, mstSet);// Pick the minimum key vertex from the set of vertices not yet included in MST
			mstSet[u] = true;
			// Update key value and parent index of the adjacent vertices of the picked vertex. Consider only those vertices which are not yet included in MST		
			for(int v = 0; v < V; v++){
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		printMST(graph, parent);		
	}
	// A utility function to find the vertex with minimum key value, from the set of vertices not yet included in MST
	public static int minKey(int[] key, boolean[] mstSet){
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		
		for(int v = 0; v < V; v++){
			if(mstSet[v] == false && key[v] < min){
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	public static void printMST(int[][] graph, int[] parent){
		System.out.println("Edge" + "----" + "Parent");
		for(int i = 1; i < V; i++){
			System.out.println(parent[i] + "-" + i + "-----" + graph[i][parent[i]]);
		}
	}
}
