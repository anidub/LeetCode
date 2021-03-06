package Numbers;

import java.util.LinkedList;
import java.util.List;
/*
 * https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class NestedSum {
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int depthSum(List<NestedInteger> nestedList) {
	    return helper(nestedList, 1);
	}
	 
	public int helper(List<NestedInteger> nestedList, int depth){
	    if(nestedList==null||nestedList.size()==0)
	        return 0;
	 
	    int sum=0;
	    for(NestedInteger ni: nestedList){
	        if(ni.isInteger()){
	            sum += ni.getInteger() * depth;
	        }else{
	            sum += helper(ni.getList(), depth+1);
	        }
	    }	 
	    return sum;
	}
	
	public int depthSumIterative(List<NestedInteger> nestedList) {
	    int sum=0;
	 
	    LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
	    LinkedList<Integer> depth = new LinkedList<Integer>();
	 
	    for(NestedInteger ni: nestedList){
	        queue.offer(ni);
	        depth.offer(1);
	    }
	 
	    while(!queue.isEmpty()){
	        NestedInteger top = queue.poll();
	        int dep = depth.poll();
	 
	        if(top.isInteger()){
	            sum += dep*top.getInteger();
	        }else{
	            for(NestedInteger ni: top.getList()){
	                queue.offer(ni);
	                depth.offer(dep+1);
	            }
	        }
	    }	 
	    return sum;
	}

}
