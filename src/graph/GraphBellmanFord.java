package graph;
/*
 * Given a graph and a source vertex src in graph, find shortest paths from src to all vertices in the given graph. The graph may contain negative weight edges.
 *  Dijksra’s algorithm is a Greedy algorithm and time complexity is O(VLogV) (with the use of Fibonacci heap). 
 *  Dijkstra doesn’t work for Graphs with negative weight edges, Bellman-Ford works for such graphs. 
 *  Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
 *  http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
 *  https://www.youtube.com/watch?annotation_id=annotation_4172016187&feature=iv&index=1&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&src_vid=lAXZGERcDf4&v=-mOEd_3gTK0
 */
public class GraphBellmanFord {

	protected static class Graph{
		int V;
		int E;
		Edge edge[];
		
		public Graph(int v, int e){
			this.V = v;
			this.E = e;
			edge = new Edge[e];
			for(int i = 0; i < e; i++){
				edge[i] = new Edge();
			}
		}
	}
	
	protected static  class Edge{
		int src; int dest; int distance;
		public Edge(){
			src = dest = distance = 0;
		}
	}
	
	public static void main(String[] args) {
		int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph
 
        Graph graph = new Graph(V, E);
 
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].distance = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].distance = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].distance = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].distance = 2;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].distance = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].distance = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].distance = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].distance = -3;
        shortestPathBellmanFord(graph,0);

	}
	
	public static void shortestPathBellmanFord(Graph graph, int src){
		int V = graph.V;
		int E = graph.E;
		int[] distance = new int[V];
		
		for(int i = 0; i < V; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		
		for(int i = 1; i < V; i++){
			for(int j = 0; j < E; j++){
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].distance;
				
				if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
					distance[v] = distance[u] + weight;
				}				
			}
		}
		
		for(int j = 0; j < E; j++){
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].distance;
			
			if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
				System.out.println("The graph contains negative cycles");
			}	
		}
		
		print(distance, V);
	}
	
	public static  void print(int dist[], int V) {
	        System.out.println("Vertex   Distance from Source");
	        for (int i=0; i<V; ++i)
	            System.out.println(i+"--------    "+dist[i]);
	    }

}
