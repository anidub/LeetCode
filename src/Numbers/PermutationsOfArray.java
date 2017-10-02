package Numbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//https://www.programcreek.com/2013/02/leetcode-permutations-java/
public class PermutationsOfArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,3};
		permute(arr);
		for(List<Integer> a : ret){
			for(int i : a){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	 	static List<List<Integer>> ret;
	 	//with duplicates//the complexity is O(n!).
	 	//http://www.lifeincode.net/programming/leetcode-permutations-and-permutations-ii-java/
	    public static List<List<Integer>> permute(int[] num) {
	        ret = new LinkedList<>();
	        LinkedList<Integer> numbers = new LinkedList<>();
	        for (int i = 0; i < num.length; i++)
	            numbers.add(num[i]);
	        LinkedList<Integer> list = new LinkedList<>();
	        permute(numbers, list);
	        return ret;
	    }
	    
	    private static void permute(List<Integer> numbers, List<Integer> list) {
	    	 if (numbers.size() == 0) {
	            LinkedList<Integer> newList = new LinkedList<>(list);
	            ret.add(newList);
	            return;
	        }
	        for (int i = 0; i < numbers.size(); i++) {
	            int candidate = numbers.get(i);
	            numbers.remove(i);
	            list.add(candidate);
	            permute(numbers, list);
	            list.remove(list.size() - 1);
	            numbers.add(i, candidate);
	        }
	    }
	
	  //without duplicates//the complexity is O(n!).
	    //https://stackoverflow.com/questions/2920315/permutation-of-array
	public static void  getAllPermutations(int[] arr){
		List<List<Integer>> all = new ArrayList<List<Integer>>();
		getPermutation(all, new ArrayList<Integer>(), arr);
		for(List<Integer> a : all){
			for(int i : a){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static void getPermutation(List<List<Integer>> all, ArrayList<Integer> result, int[] arr){
		if(arr.length == result.size()){
			List<Integer> temp = new ArrayList<Integer>(result);
			all.add(temp);
		}
		for(int i = 0; i < arr.length; i++){
			if(!result.contains(arr[i])){
				result.add(arr[i]);
				getPermutation(all,result,arr);
				result.remove(result.size()-1);
			}
		}
	}
}
