package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
/*
 * Longest Path in a Directed Acyclic Graph | Set 2
Given a Weighted Directed Acyclic Graph (DAG) and a source vertex in it, find the longest distances from source vertex to all other vertices in the given graph.

http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
http://www.geeksforgeeks.org/longest-path-directed-acyclic-graph-set-2/
Time complexity of topological sorting is O(V + E).

We use Topological sorting because 
If we don't sort it, we don't know which adjacent vertex to choose first and it may lead to a situation
 where we use distance of a vertex v to update distances of its adjacent vertices adj[v], 
but after that, the distance of vertex v gets updated, so vertices from adj[v] could also get bigger distances, but we won't visit them anymore.
 */
public class longestPathDirectedAcyclic {

	static class AdjListNode {
		int v;
		int weight;

		public AdjListNode(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		int getV() {
			return v;
		}

		int getWeight() {
			return weight;
		}
	}

	static int V;
	static LinkedList<AdjListNode> adj[];

	public static void main(String[] args) {

	}

	public static void topologicalSort(int s, boolean[] visited, Stack<Integer> stack, Graph graph) {
		visited[s] = true;
		Iterator it = graph.adj[s].listIterator();
		while (it.hasNext()) {
			int n = (int) it.next();
			if (!visited[n]) {
				topologicalSort(n, visited, stack, graph);
			}
		}
		stack.push(s);
	}

	public static void longestPath(Graph graph, int s) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				topologicalSort(i, visited, stack, graph);
		}

		int[] minDist = new int[V];
		for (int i = 0; i < V; i++) {
			minDist[i] = Integer.MIN_VALUE;
		}
		minDist[s] = 0;
		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (minDist[u] != Integer.MIN_VALUE) {
				
				for (AdjListNode v : adj[u]) {
					if (minDist[v.getV()] < minDist[u] + v.getWeight())
						minDist[v.getV()] = minDist[u] + v.getWeight();
				}
				
			}
		}
		for (int i = 0; i < V; i++) {
			if (minDist[i] == Integer.MIN_VALUE)
				System.out.println("INT_MIN ");
			else
				System.out.println(minDist[i]);
		}
	}
}