package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSortKahnAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void topologialSort(Graph graph){
		int V = graph.V;
		int[] indegree = new int[V];
		for(int i = 0; i < V; i++){
			LinkedList<Integer> temp = 	(LinkedList<Integer>) graph.adj[i];
			for(int node : temp){
				indegree[i]++;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < V; i++){
			if(indegree[i] == 0){
				queue.add(i);
			}
		}
		int count = 0;
		ArrayList<Integer> topOrder = new ArrayList<>();
		while(!queue.isEmpty()){
			int u = queue.poll();
			topOrder.add(u);
			for(int node : graph.adj[u]){
				if(--indegree[node] == 0){
					queue.add(node);
				}
			}
			count++;
		}
		if(count != V){
			System.out.println("there is a cycle");
			return;
		}
		for(int i : topOrder){
			System.out.println(i);
		}
	}

}
