package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

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
		AllPossiblePaths.addEdge(0,1);
		AllPossiblePaths.addEdge(0,2);
		AllPossiblePaths.addEdge(0,3);
		AllPossiblePaths.addEdge(2,0);
		AllPossiblePaths.addEdge(2,1);
		AllPossiblePaths.addEdge(1,3);
	     
	        // arbitrary source
	        int s = 2;
	     
	        // arbitrary destination
	        int d = 3;
	     
	        System.out.println("Following are all different paths from "+s+" to "+d);
	       // AllPossiblePaths.printAllPathsBFS(s, d);
	        AllPossiblePaths.findpaths(s,d);
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
	
	
	// utility function to check if current
	// vertex is already present in path
	public static boolean isNotVisited(int x, ArrayList<Integer> path){
	    int size = path.size();
	    for (int i = 0; i < size; i++) {
	        if (path.get(i) == x) 
	            return false; 
	    }
	    return true;
	}
	 
	// utility function for finding paths in graph
	// from source to destination
	public static void findpaths(int source, int destination){
		//ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
		// create a queue which stores
	    // the paths
	    /*Queue<ArrayList<Integer>> q = new LinkedList<>();
	 
	    // path vector to store the current path
	    ArrayList<Integer> path = new ArrayList<>();
	    path.add(src);
	    q.add(path);
	    while (!q.isEmpty()) {
	        path = q.poll();
	        int last = path.get(path.size() - 1);
	 
	        // if last vertex is the desired destination
	        // then print the path
	        if (last == dst) 
	            printpath(path);        
	 
	        // traverse to all the nodes connected to 
	        // current vertex and push new path to queue
	        for (int i = 0; i < allPaths.get(last).size(); i++) {
	            if (isNotVisited(allPaths.get(last).get(i), path)) {
	                ArrayList<Integer> newpath = new ArrayList<>(path);
	                newpath.add(allPaths.get(last).get(i));
	                q.add(newpath);
	            }
	        }
	        
	    }*/
		
		 boolean visited[] = new boolean[v];
		 
	        // Create a queue for BFS
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	 
	        // Mark the current node as visited and enqueue it
	        queue.add(source);
	        ArrayList<Integer> localPath = new ArrayList<>();
	        while (!queue.isEmpty()){
	            // Dequeue a vertex from queue and print it
	        	 int src = queue.poll();	 
	        	 if(!localPath.contains(src)){
	        		 localPath.add(src);
	        	 }
	        	if(src == destination){
	        		System.out.println(localPath);
	        		localPath.remove(localPath.size()-1);
	        	}
	            // Get all adjacent vertices of the dequeued vertex s If a adjacent has not been visited, then mark it visited and enqueue it
	            Iterator<Integer> i = adj[src].listIterator();
	            while (i.hasNext()) {
	                int n = i.next();	                
	                //if (!visited[n]){
	                if(!localPath.contains(n)){
	                	//localPath.add(n);
	                   // visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	}
	
	static  void printpath(ArrayList<Integer> path)	{
	    int size = path.size();
	    for (int i = 0; i < size; i++){ 
	        System.out.print(path.get(i));    
	    }
	    System.out.println();
	    
	}
}