package Tree;

import java.util.Stack;

public class FlattenBTreeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
			if(!stack.isEmpty())
				cur.right = stack.peek();
			cur.left = null;
		}
	}

}
