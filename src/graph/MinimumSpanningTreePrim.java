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

Explanation : https://www.youtube.com/watch?v=PzznKcMyu0Y
 */
public class MinimumSpanningTreePrim {
	private static int V = 5;
	public static void main(String[] args) {

	}
	
	public static void minimumSpanningTree(int[][] graph){
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];
		
		for(int v = 0; v < V; v++){
			key[v] = Integer.MAX_VALUE;
			mstSet[v] = false;
		}
		parent[0] = -1;
		key[0] = 0;
		
		for(int count = 0; count < V-1; count++){
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			
			for(int v = 0; v < V; v++){
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		printMST(graph, parent);		
	}
	
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
