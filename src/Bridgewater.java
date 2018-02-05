import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Bridgewater {
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int i) {
			this.data = i;
			this.left = null;
			this.right = null;
			
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}	
		
	}

	public static void main(String[] args) {
		//System.out.println(minFlipsToMakeSame(null));
	/*	TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(21);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(1);*/
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(6);
		//root.right.left = new TreeNode(1);
		//System.out.println(treeproblem(root));
		//System.out.println(StackProblem("13 DUP 4 POP 5 DUP + DUP + -"));
		System.out.println(monotonic(new int[]{1, 4, 7, 3, 3, 5}));
		System.out.println(sol(new int[]{1, 4, 7, 3, 3, 5}));
	}
	

	public static int monotonic(int[] array) {
		if (array.length == 1) {
			return -1;
		}
		int result = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i : array){
			set.add(i);
		}
		for(int i = 0; i < array.length; i++){
			for(int j = i+1; j < array.length; j++){
				if(array[j] == array[i]) continue;
				int low;
				int high;
				if(array[j] < array[i]){
					low = array[j];
					high = array[i];
				}else{
					low = array[i];
					high = array[j];
				}
				boolean elementNotExists = search(set, low, high);
				if(elementNotExists){
					result = Math.max(result, j-i);
				}
			}
			
		}
		return result;
		
	}
	
	public static int sol(int[] arr){
		int max = 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for(int i = 0; i < arr.length; i++){
			int element = arr[i];
			ArrayList<Integer> list = map.get(element);
			if(list == null){
				list = new ArrayList<>();
			}
			list.add(i);
			map.put(element, list);
			if(element > max)
				max = element;			
		}
		int largestStartIndex = 0;
		int largestEndIndex = arr.length-1;
		int[] tempArray = new int[max];
		boolean flag = false;
		for(int i = 0; i < tempArray.length; i++){
			if(map.containsKey(i)){
				tempArray[i] = 1;
			}
		}

		int largestDistance = 0;
		ArrayList<Integer> answerArray = new ArrayList<>();
		for(int i = 0; i < tempArray.length; i++){
			if(tempArray[i] ==  1 && flag == false){
				flag = true;
				largestStartIndex = i;
			}
			if(tempArray[i] == 1 && flag == true){
				flag = false;
				largestEndIndex = i;
			}
			
			int tempDistance = largestEndIndex - largestStartIndex;
			if(largestDistance < tempDistance){
				largestDistance = tempDistance;
			}
		}
		return -1;
	}
	
	public static boolean search(HashSet<Integer> set, int low, int high){
		low++;
		high--;
		for(int i = low; i <= high; i++){
			if(set.contains(i))
				return false;
		}
		return true;
	}
	
	public static boolean binarySearch(int[] arr, int target){
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high){
			int mid = low + ((high - low) / 2);
			if(target < arr[mid])
				high = mid-1;
			else if(target > arr[mid])
				low = mid+1;
			else if(target == arr[mid]){
				return true;
			}				
		}
			return false;
	}
	
	


	
	
	
	  public static int StackProblem(String s) {
	      if(s == null || s.length() == 0) return -1;
	      
		  Stack<Integer> stack = new Stack<Integer>();
	      String[] arr =  s.split(" ");
	      for(int i = 0; i < arr.length; i++){
	    	  String current = arr[i];
	    	  if(current.equals("DUP")){
	    		  if(!stack.isEmpty()){
	    			  stack.add(stack.peek());
	    		  }else{
	    			  return -1;
	    		  }
	    	  }else if(current.equals("POP")){
	    		  if(!stack.isEmpty()){
	    			  stack.pop();
	    		  }else{
	    			  return -1;
	    		  }
	    	  }else if(current.equals("+")){
	    		  if(!stack.isEmpty() && stack.size() > 1){
	    			  int i1 = stack.pop();
	    			  int i2 = stack.pop();
	    			  stack.push(i1+i2);
	    		  }else{
	    			  return -1;
	    		  }
	    	  }else if(current.equals("-")){
	    		  if(!stack.isEmpty() && stack.size() > 1){
	    			  int i1 = stack.pop();
	    			  int i2 = stack.pop();
	    			  if(i1 - i2 < 0) return -1;
	    			  stack.push(i1-i2);
	    		  }else{
	    			  return -1;
	    		  }
	    	  }else{
	    		  stack.push(Integer.parseInt(current));
	    	  }
	      }
		if (stack.isEmpty()) {
			return -1;
		}
	      return stack.peek();
	    }
	  
	  
    public static  int treeproblemVisibleNodes(TreeNode T) {
        if(T == null)
            return 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(T);
        int result = 0;
        while(!queue.isEmpty()){
        	TreeNode temp = queue.poll();
            if(temp.data >= max){
                result++;
                max = temp.data;
            }
            if(temp.left != null){
                queue.add(temp.left);    
            }
            if(temp.right != null){
                queue.add(temp.right);   
            }            
        }
        return result;
    }
    
    public static int minFlipsToMakeSame(int[] B) {       
        int[] A = {0,0,1,1,1,1};
        int result = 0;
        if(A == null || A.length == 0)
            return result;
        int onesSum = 0;
        int zeroesSum = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 1){
                onesSum = onesSum+1;    
            }
        }
        zeroesSum = A.length - onesSum;
        if(onesSum == A.length || zeroesSum == A.length){
            System.out.println(result);
            return result;    
        }else{
            result = onesSum <  zeroesSum ? onesSum : zeroesSum;
            System.out.println(result);
            return result;
        }
    }
    


}
