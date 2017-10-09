package graph;
/*
 *  find shortest distances between every pair of vertices in a given edge weighted directed Graph.
 *  Floyd-Warshall Algorithm for finding all pair shortest path.
 *   * Time complexity - O(V^3)
 * Space complexity - O(V^2)
 * 
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/FloydWarshallAllPairShortestPath.java
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 */
public class FloydWarshallShortest {
	 final static int INF = 99999, V = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void shortest(int[][] graph){
		int[][] dist = new int[V][V];
		
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				dist[i][j] = graph[i][j];
			}
		}
		
		for(int k = 0; k < V; k++){
			for(int i = 0; i < V; i++){
				for(int j = 0; j < V; j++){
					if(dist[i][k] + dist[k][j] <  dist[i][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		 // Print the shortest distance matrix
        printSolution(dist);
	}
	
	public static void printSolution(int dist[][]) {
		System.out.println("Following matrix shows the shortest distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
