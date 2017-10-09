package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Clone an Undirected Graph
 * http://www.geeksforgeeks.org/clone-an-undirected-graph/
 * How to verify if the cloned graph is a correct?
Do a BFS traversal before and after the cloning of graph. In BFS traversal display the value of a node along with its address/reference.
Compare the order in which nodes are displayed, if the values are same but the address/reference is different for both the traversals than the cloned graph is correct.
 * 
 */
public class cloneGraph {

	static class GraphNode{
		int v;
		ArrayList<GraphNode> neighbors;
		
		public GraphNode(int v){
			this.v = v;
			neighbors = new ArrayList<>();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static GraphNode clone(GraphNode source){
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(source);
		HashMap<GraphNode,GraphNode> map = new HashMap<>();
		map.put(source, new GraphNode(source.v));
		
		while(!queue.isEmpty()){
			GraphNode u = queue.poll();
			GraphNode cloneNodeU = map.get(u);
			if (u.neighbors != null) {
				ArrayList<GraphNode> neighbors = u.neighbors;
				for (GraphNode graphNode : neighbors) {
					GraphNode cloneNodeG = map.get(graphNode);
					if (cloneNodeG == null) {
						queue.add(graphNode);
						cloneNodeG = new GraphNode(graphNode.v);
						map.put(graphNode, cloneNodeG);
					}
					cloneNodeU.neighbors.add(cloneNodeG);
				}
			}
		}
		return map.get(source);
	}

}
