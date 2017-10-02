package Tree;
/*
 * https://www.careercup.com/question?id=6266917077647360
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes. 

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.


/* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 *          
 *          
 *1. Recursively traverse to the leftmost node. 
2. This becomes the NewRoot, and keep returning this value, up the chain. 
3. Make the following changes 
- CurrentRoot. Left.Left = CurrentRoot.Right 
- CurrentRoot.Left.Right = CurrentRoot 
- CurrentRoot.Left = CurrentRoot.Right = NULL
 */
 
public class FlipUpsideDownWithRightLeaf {

	public static void main(String[] args) {
		
	}

	public static TreeNode flip(TreeNode root){
		if(root == null) return null;
		if(root.left == null && root.right == null) return root.left;
		
		TreeNode newRoot = flip(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = root.right = null;
		return newRoot;
	}
}
