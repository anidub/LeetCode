package Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetPermutationCombinationSumPalindromePartionting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static List<List<Integer>> subsetsDistict(int[] arr){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		backtrackDistict(res, new ArrayList<>(), arr, 0);
		return res;
	}
	/*
	 * https://leetcode.com/problems/subsets/description/
	 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
	 */
	public static void backtrackDistict(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int start){
		res.add(new ArrayList<Integer>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrackDistict(res, tempList, nums, i+1);
			//if non distinct 
			//backtrackNonDistict(res, tempList, nums, i+1)
			tempList.remove(tempList.size()-1);	
		}
	}
	
	/*
	 * https://leetcode.com/problems/subsets-ii/description/
	 * If arr contains non distinct numbers
	 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
	 */
	public static void backtrackNonDistict(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int start){
		res.add(new ArrayList<Integer>(tempList));
		for(int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i-1]) continue;
			tempList.add(nums[i]);
			backtrackDistict(res, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);	
		}
	}
	
	/*
	 * https://leetcode.com/problems/permutations/description/
	 * Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
	 */
	public static List<List<Integer>> PermutationsDistict(int[] arr){
		List<List<Integer>> res = new ArrayList<>();
		backtrackPermutations(res, new ArrayList<>(), arr);
		return res;
	}
	
	public static void backtrackPermutations(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){
			res.add(new ArrayList<>(tempList));
		}
		for(int i = 0; i < nums.length; i++){
			if(tempList.contains(nums[i])) continue;
			tempList.add(nums[i]);
			backtrackDistict(res, tempList, nums, i+1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	/*
	 * https://leetcode.com/problems/permutations-ii/description/
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]USE THIS
	 */
	public static List<List<Integer>> PermutationsNonDistict(int[] arr){
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[arr.length];
		backtrackNonDistinctPermutations(res, new ArrayList<>(), arr,visited);
		return res;
	}
	
	public static void backtrackNonDistinctPermutations(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, boolean[] visited){
		if(tempList.size() == nums.length){
			res.add(new ArrayList<>(tempList));
		}
		
		for(int i = 0; i < nums.length; i++){
			if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
			visited[i] = true;
			tempList.add(nums[i]);
			backtrackDistict(res, tempList, nums, i+1);
			tempList.remove(tempList.size() - 1);
		}
	}

}
