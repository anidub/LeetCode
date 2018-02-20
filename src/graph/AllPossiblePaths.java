package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AllPossiblePaths {

	static int v; // number of vertices
	static ArrayList<Integer> adj[]; // adjacency list
	
	
	public AllPossiblePaths(int v){
		this.v = v;
		adj = new ArrayList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new ArrayList<>();
		}
	}
	
	// add edge from u to v
	public static void addEdge(int u, int v){
 		adj[u].add(v);
	}
	
	public static void main(String[] args) {
		AllPossiblePaths g = new AllPossiblePaths(4);
		AllPossiblePaths.addEdge(0, 1);
		AllPossiblePaths.addEdge(0, 2);
		AllPossiblePaths.addEdge(0, 3);
		AllPossiblePaths.addEdge(2, 0);
		AllPossiblePaths.addEdge(2, 1);
		AllPossiblePaths.addEdge(1, 3);

		// arbitrary source
		int s = 2;

		// arbitrary destination
		int d = 3;

		System.out.println("Following are all different paths from " + s + " to " + d);
		// AllPossiblePaths.printAllPathsBFS(s, d);
		AllPossiblePaths.printAllPathsBFS(s, d);
	}
	
	//Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
	//https://www.geeksforgeeks.org/find-paths-given-source-destination/
	//   Prints all paths from 's' to 'd'
	public static void printAllPathsBFS(int source, int destination){
		boolean[] visited = new boolean[v];
		ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
		ArrayList<Integer> localPath = new ArrayList<>();
		
		localPath.add(source);
		
		printAllPathsBFSUtil(allPaths, localPath, source, destination, visited);
	}
	
	 // A recursive function to print all paths from 'u' to 'd'.Visited[] keeps track of vertices in current path. localPath stores actual
	public static void printAllPathsBFSUtil(ArrayList<ArrayList<Integer>> allPaths, ArrayList<Integer> localPath, int current, int destination, boolean[] visited){
		visited[current] = true;
		if(current == destination){
			allPaths.add(localPath);
			System.out.println(localPath);
		}
		// Recur for all the vertices adjacent to current vertex
		for(int i : adj[current]){
			if(!visited[i]){
				 // store current node 
				localPath.add(i);
				printAllPathsBFSUtil(allPaths, localPath, i, destination, visited);
				
				 // remove current node
				localPath.remove(localPath.size()-1);
			}
		}
		visited[current] = false;
	}
}