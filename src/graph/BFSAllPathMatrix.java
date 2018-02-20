package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSAllPathMatrix {
//not working see line 73
	public static void main(String[] args) {
		/*
		 * ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // number of
		 * vertices int v = 4; for(int i = 0; i < 3; i++){ graph.add(new
		 * ArrayList<Integer>()); }
		 * 
		 * // construct a graph graph.get(0).add(3); graph.get(0).add(1);
		 * graph.get(0).add(2); graph.get(1).add(3); graph.get(2).add(0);
		 * graph.get(2).add(1);
		 */
		
		List<Integer>[] graph = new List[3];
		for(int i = 0; i < 3; i++){
			graph[i] = new ArrayList<>();
		}
		graph[0].add(3);
		graph[0].add(1);
		graph[0].add(2); 
		graph[1].add(3); 
		graph[2].add(0);
		graph[2].add(1);
		int v = 4;
		int src = 2, dst = 3;
		System.out.println("path from src " + src + " to dst " + dst + " are ");
		// function for finding the paths
		findpaths(graph, src, dst, v);
	}
	
	// utility function for printing the found path in graph
	static void printpath(ArrayList<Integer> path){
	    int size = path.size();
	    for (int i = 0; i < size; i++) {
	        System.out.println(path.get(i) + " ");
	    }
	}
	 
	// utility function to check if current vertex is already present in path
	static boolean isNotVisited(int x, ArrayList<Integer> path){
	    int size = path.size();
	    for (int i = 0; i < size; i++){ 
	        if (path.get(i) == x) 
	            return false; 
	    }
	    return true;
	}
	 
	// utility function for finding paths in graph from source to destination
	static void findpaths(List<Integer>[] graph, int src, int dst, int v){
	    // create a queue which stores the paths
	    LinkedList<ArrayList<Integer>> q = new LinkedList<>();
	 
	    // path vector to store the current path
	    ArrayList<Integer> path = new ArrayList<>();
	    path.add(src);
	    q.add(path);
	    while (!q.isEmpty()) {
	        path = q.removeFirst();
	        int last = path.get(path.size() - 1);
	 
	        // if last vertex is the desired destination then print the path
	        if (last == dst) 
	            printpath(path);        
	 
	        // traverse to all the nodes connected to current vertex and push new path to queue
	        for (int i = 0; i < graph[last].size(); i++) {//last has to be number and not index..that is the problem
	            if (isNotVisited(graph[last].get(i), path)) {
	            	ArrayList<Integer> newpath = new ArrayList<>(path);
	                newpath.add(graph[last].get(i));
	                q.push(newpath);
	            }
	        }
	    }
	}
}