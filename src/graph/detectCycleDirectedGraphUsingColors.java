package graph;

import java.util.Iterator;

public class detectCycleDirectedGraphUsingColors {
	
	public enum Color { white, gray, black};
	public static void main(String[] args){
		
	}
	
	public static boolean isCyclic(Graph graph){
		int V = graph.V;
		int[] color = new int[V];
		for(int i = 0; i < V; i++){
			color[i] = Color.white;
		}
		
		for(int i = 0; i < V; i++){
			if(color[i] == white){
				if(dfsUtil(i, color, graph) == true)
					return true;
			}
		}
		return false;
	}
	
	public static boolean dfsUtil(int v, int[] color, Graph graph){
		color[v] = gray;
		
		Iterator it = graph.adj[v].listIterator();
		while(it.hasNext()){
			int n = it.next();
			if(color[n] == gray)
				return true;
			if(color[n] == white && dfsUtil(n,color,graph))
				return true;
		}
		
		color[v] = black;
		return false;
	}
}
