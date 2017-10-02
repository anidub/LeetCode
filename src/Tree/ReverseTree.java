package Tree;
/*
 * I was looking at interview questions and I recently came upon one that asked you how to reverse a general binary tree, like flip it from right to left.

So for example if we had the binary tree

 6
/   \
3     4
/ \   / \
7   3 8   1
Reversing it would create

 6
/   \
4     3
/ \   / \
1   8 3   7
https://stackoverflow.com/questions/9460255/reverse-a-binary-tree-left-to-right
 */
public class ReverseTree {

	public static void reverse(TreeNode root){
		if(root == null) return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null) reverse(root.left);
		if(root.right != null) reverse(root.right);
	}
}
