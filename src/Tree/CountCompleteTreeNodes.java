package Tree;
/*
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * https://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
 * Steps to solve this problem:
1) get the height of left-most part
2) get the height of right-most part
3) when they are equal, the # of nodes = 2^h -1
4) when they are not equal, recursively get # of nodes from left&right sub-trees

time complexity=O(h^2).
Finding a height costs O(log(n)). So overall O(log(n)^2).
The space complexity will just be the size of the call stack, which is O(h).
https://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left  = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.println(countComplete(root));
	}

	
	public static int countComplete(TreeNode root){
		if(root == null) return 0;
		int left = getLeft(root)+1;
		int right = getRight(root)+1;
		
		if(left == right){
			return  (2<<(left-1))-1;// or N = (2^depth-1).
		}else{
			return countComplete(root.left) + countComplete(root.right) + 1;
		}
		
	}
	
	public static int getLeft(TreeNode root){
		if(root == null) return 0;
		int depth = 0;
		while(root.left != null){
			root = root.left;
			depth++;
		}
		return depth;
	}
	
	public static int getRight(TreeNode root){
		if(root == null) return 0;
		int depth = 0;
		while(root.right != null){
			root = root.right;
			depth++;
		}
		return depth;
	}
}
