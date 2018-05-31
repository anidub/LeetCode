package Tree;
/*
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 *  For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 1. Print the left boundary in top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.

Time Complexity: O(n)
 */
public class printBoundary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void printBoundary(TreeNode root){
		if(root != null){
			System.out.println(root.data);	
			// Print the left boundary in top-down manner.
			printLeft(root.left);
			
			// Print all leaf nodes
			printLeaves(root.left);
			printLeaves(root.right);
			
			// Print the right boundary in bottom-up manner
			printRight(root.right);
		}
	}
	
	  // A function to print all left boundry nodes, except a leaf node. Print the nodes in TOP DOWN manner
	public static void printLeft(TreeNode root){
		if(root != null){
			if(root.left != null){
				// to ensure top down order, print the node before calling itself for left subtree
				System.out.println(root.data);
				printLeft(root.left);
			}else{
				System.out.println(root.data);
				printLeft(root.right);
			}			
		}
	}
	
	 // A function to print all right boundry nodes, except a leaf node Print the nodes in BOTTOM UP manner
	public static void printRight(TreeNode root){
		if(root != null){
			if(root.right != null){		
				// to ensure bottom up order, first call for right subtree, then print this node
				printRight(root.right);
				System.out.println(root.data);
			}else{
				printRight(root.left);
				System.out.println(root.data);
			}			
		}
	}
	
	// A simple function to print leaf nodes of a binary tree
	public static void printLeaves(TreeNode root){
		if(root != null){
			printLeaves(root.left);
			 // Print it if it is a leaf node
			if(root.left == null && root.right == null){
				System.out.println(root.data);
			}
			printLeaves(root.right);
		}			
	}
}