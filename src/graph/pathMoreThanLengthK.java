package graph;

import java.util.LinkedList;
import java.util.ListIterator;


public class pathMoreThanLengthK {
 private class Graph{
	 int V;
	// Edge[] edge;
	 LinkedList<Edge> adj[];
	 
	 public Graph(int v){
		 this.V = v;
		 for(int i = 0; i < v; i++){
			 adj[i] = new LinkedList<Edge>();
		 }
	 }
	 
	 public void addEdge(int source, int destination, int weight){
		 adj[source].add(new Edge(destination,weight));
		 adj[destination].add(new Edge(source,weight));
	 }
	 
 }
 
 private static class Edge{
	 int destination;
	 int weight;
	 
	 public Edge(){
		 destination = weight = 0;
	 }
	 public Edge(int destination, int weight){
		 this.destination =  destination;
		 this.weight = weight;
	 }
 }

	public static void main(String[] args) {

	}
	
	public static boolean hasPathMoreThanK(int src, int k, Graph graph){
		boolean[] path = new boolean[graph.V];
		path[src] = true;
		return hasPathMoreThanKUtil(src, k, graph, path);
	}
	
	public static boolean hasPathMoreThanKUtil(int src, int k, Graph graph, boolean[]  path){
		if(k <= 0) return true;
		ListIterator<Edge> it = graph.adj[src].listIterator();
		while(it.hasNext()){
			
			int v = it.next().destination;
			int w = it.next().weight;
			
			if(path[v] == true) continue;
			
			if(w >= k) return true;
			path[v] = true;
			
			if(hasPathMoreThanKUtil(v, k-w, graph,path))
				return true;
			
			path[v] = false;			
		}
		return false;
	}
}
	

