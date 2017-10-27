package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class rightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Reverse Level Order Traversal, java
	 */
	public static List<Integer> rightSide(TreeNode root){
		if(root == null) return null;
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int nodecount = queue.size();
			for(int i = 0; i < nodecount; i++){
				TreeNode node = queue.poll();
				if(i == 0) result.add(node.data);
				if(node.right != null)
					queue.add(node.right);
				if(node.left != null)
					queue.add(node.left);
			}			
		}
		return result;
	}
	
	/*
	 * The core idea of this algorithm:

1.Each depth of the tree only select one node.

View depth is current size of result list. 
https://leetcode.com/problems/binary-tree-right-side-view/discuss/	
	 */
	public static List<Integer> rightSideDFS(TreeNode root){
		if(root == null) return null;
		List<Integer> result = new ArrayList<>();
		rightSideDFS(root, result, 0);
		return result;
	}
	
	public static void rightSideDFS(TreeNode root, List<Integer> result, int curDepth){
		if(root == null) return;
		if(curDepth == result.size())
			result.add(root.data);
		rightSideDFS(root.right,result, curDepth+1);
		rightSideDFS(root.left, result, curDepth+1);
	}

}
