package graph;

import java.util.Iterator;
/*
 * http://www.geeksforgeeks.org/iterative-deepening-searchids-iterative-deepening-depth-first-searchiddfs/
 * READ : https://stackoverflow.com/questions/7395992/iterative-deepening-vs-depth-first-search
 * The idea behind iterative deepening is to use this second approach but to keep increasing the depth at each level. 
 * In other words, we might try exploring using all paths of length one, then all paths of length two, then length three, etc. 
 * until we end up finding the node in question. This means that we never end up exploring along infinite dead-end paths, 
 * since the length of each path is capped by some length at each step. It also means that we find the shortest possible path
 *  to the destination node, since if we didn't find the node at depth d but did find it at depth d + 1, 
 *  there can't be a path of length d (or we would have taken it), so the path of length d + 1 is indeed optimal.
 *  
 *  b : number of children of each node
 *  d : depth
 *  Time complexity : B^d
 *  Space complexity: bd
 */
public class IterativeDeepeningDFS {

	public static void main(String[] args) {

	}
	
	public static boolean IDDFS(int source, int target, int maxDepth,Graph graph){
		for(int i = 0; i < maxDepth; i++){
			if(DLS(i,target,maxDepth,graph) == true)
				return true;
		}
		return false;
	}
	
	public static boolean DLS(int source, int target, int maxDepth, Graph graph){
		if(source == target) return true;
		if(maxDepth <= 0) return false;
		Iterator it = graph.adj[source].listIterator();
		while(it.hasNext()){
			int n = (int) it.next();
			if(DLS(n,target,maxDepth-1, graph) == true)
				return true;
		}
		return false;
	}
}
