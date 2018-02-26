package Tree;
/*
 * https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. 
 * A Single Valued Subtree is one in which all the nodes have same value.
 * Input: root of below tree
              5
             / \
            4   5
           / \   \
          4   4   5                
Output: 5
 * time complexity is O(n).
 */
public class CountUnivalueSubTrees {
	static class Count{
	    int count = 0;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);        
        System.out.println(countUnivalue(root));
	}
	
	public static int countUnivalue(TreeNode root){
		//int count = 0;
		Count count = new Count();
		countUnivalueRec(root, count);
		return count.count;
	}
	
	public static boolean countUnivalueRec(TreeNode root, Count count){
		if(root == null) return true;
		
		boolean left = countUnivalueRec(root.left, count);
		boolean right = countUnivalueRec(root.right, count);
		
		if(left == false || right == false) return false;
		if(root.left != null && root.left.data != root.data)
			return false;
		if(root.right != null && root.right.data != root.data)
			return false;
		
		count.count++;
		return true;
	}
}