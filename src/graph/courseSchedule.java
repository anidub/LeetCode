package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1. So it is impossible.
 
 https://leetcode.com/problems/course-schedule/description/
 
 https://leetcode.com/problems/course-schedule/discuss/58524/Java-DFS-and-BFS-solution
 */
public class courseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites = new int[2][2];
		int[] one = new int[2]; one[0] = 1; one[1] = 0;
		int[] two = new int[2]; two[0] = 0; two[1] = 1;
		prerequisites[0] = one; prerequisites[1] = two;
		System.out.println(canFinish(2,prerequisites ));

	}
	
/*
 * Explanation for the DFS solution : the solution basically starts at every node in the graph which corresponds to a course and traverses all the courses (nodes) 
 * that can be taken subsequently. If we ever encounter the a course we have already visited , then we know there is a cycle.
 *  Note that in the solution , as the recursion unwinds all the visited status is set to false. 
 * Hence every time DFS is started in the can finish function , the visted boolean array is guaranteed to be all false.
 *  That is why this method works.	
 */
public static boolean canFinish(int numCourses, int[][] prerequisities){
	ArrayList[] graph = new ArrayList[numCourses];
	for(int i = 0; i < numCourses; i++){
		graph[i] = new ArrayList<Integer>(); 
	}
	//for every pre requisite create a course
	for(int i = 0; i < prerequisities.length; i++){
		graph[prerequisities[i][1]].add(prerequisities[i][0]);
	}
	
	boolean[] visited = new boolean[numCourses];
	for(int i = 0; i < numCourses; i++){
		if(!dfs(graph, visited, i)){
			return false;
		}
	}
	return true;
}

	public static boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
		if (visited[course]) {
			return false;
		} else {
			visited[course] = true;
		}

		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}
	
	
	//if you need order
	//https://leetcode.com/problems/course-schedule-ii/discuss/59342/Java-DFS-double-cache-visiting-each-vertex-once-433ms
	public static int[] getOrderOfCourses(int numCourses, int[][] prerequisites){
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < numCourses; i++){
			graph.add(i, new ArrayList<>());
		}
		
		for(int i = 0; i < prerequisites.length; i++){
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		boolean[] visited = new boolean[numCourses];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < numCourses; i++){
			if(!topoSort(graph, visited, new boolean[numCourses], i, stack)){
				return new int[0];
			}
		}
		int i = 0;
		int[] result = new int[numCourses];
		while(!stack.isEmpty()){
			result[i++] = stack.pop();
		}
		return result;
		
	}
	
	public static boolean topoSort(List<List<Integer>> graph, boolean[] visited, boolean[] isLoopWithForCourse, int course, Stack<Integer> stack){
		if(visited[course]) return true;
		if(isLoopWithForCourse[course]) return false;
		
		isLoopWithForCourse[course] = true;
		for (int i : graph.get(course)) {
			if (!topoSort(graph, visited, isLoopWithForCourse, i, stack)) {
				return false;
			}
		}
		visited[course] = true;
		stack.push(course);
		return true;
	}
}
