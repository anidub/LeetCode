package Tree;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int sumNumbers(TreeNode root) {
		return getSum(root, 0);
	}
	
	public static int getSum(TreeNode root, int sum){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return sum * 10 + root.data;
		return getSum(root.left, sum * 10 + root.data) + getSum(root.right, sum * 10 + root.data);
	}

}
