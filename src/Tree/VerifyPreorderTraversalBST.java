package Tree;

import java.util.Stack;
/*
 * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 * Check if a given array can represent Preorder Traversal of Binary Search Tree
 * Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false. 
 * 
 * Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2
     
      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /   
 30    80 
        
  35     100 


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false

1) Create an empty stack.
2) Initialize root as INT_MIN.
3) Do following for every element pre[i]
     a) If pre[i] is smaller than current root, return false.
     b) Keep removing elements from stack while pre[i] is greater
        then stack top. Make the last removed item as new root (to
        be compared next).
        At this point, pre[i] is greater than the removed root
        (That is why if we see a smaller element in step a), we 
        return false)
     c) push pre[i] to stack (All elements in stack are in decreasing
        order) 
        
 * Time complexity is O(n).
 */
public class VerifyPreorderTraversalBST {

	public static void main(String[] args) {
		
	}
	
	public static boolean verifyPreorder(int[] preorder){
		if(preorder == null || preorder.length == 0)
			return true;
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		
		for(int i = 0; i < preorder.length; i++){
			// If we find a node who is on right side and smaller than root, return false
			if(preorder[i] < root)
				return false;
			
			 // If pre[i] is in right subtree of stack top, Keep removing items smaller than pre[i] and make the last removed item as new root.
			while(!stack.isEmpty() && stack.peek() < preorder[i]){
				root = stack.peek();
				stack.pop();
			}
			
			 // At this point either stack is empty or pre[i] is smaller than root, push pre[i]
			stack.push(preorder[i]);
		}
		return true;
	}
}
