package Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*
 * https://leetcode.com/problems/combination-sum/description/
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
	public static List<List<Integer>> getCombinationSum1(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0) 
			return result;
		Arrays.sort(candidates);
		backtracking1(candidates, result, new ArrayList<Integer>(), 0, target);
		return result;		
	}
	
	public static void backtracking1(int[] candidates,List<List<Integer>> result, ArrayList<Integer> currentList, int start, int target){
		if(target < 0) return;
		else if(target == 0){
			result.add(new ArrayList<>(currentList));
		}else{
			for(int i = start; i < candidates.length; i++){
				currentList.add(candidates[i]);
				backtracking1(candidates, result, currentList, i , target-candidates[i]);
				currentList.remove(currentList.size() - 1);
			}
		}
	}
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
	 */
	public static void backtracking2(int[] candidates,List<List<Integer>> result, ArrayList<Integer> currentList, int start, int target){
		if(target < 0) return;
		else if(target == 0){
			result.add(new ArrayList<>(currentList));
		}else{
			for(int i = start; i < candidates.length; i++){
				if(i > start && candidates[i] == candidates[i-1]) continue;//skip duplicates
				currentList.add(candidates[i]);
				backtracking1(candidates, result, currentList, i , target-candidates[i]);
				currentList.remove(currentList.size() - 1);
			}
		}
	}
	/*
	 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
	 *  can be used and each combination should be a unique set of numbers.
Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]
https://leetcode.com/problems/combination-sum-iii/discuss/60719/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
 Time complexity : m*9^k; where m is possible number of solutions and its 9^k as for every k positions we have 9 options to choose from.
*/
	public static List<List<Integer>>  getCombinationSum3(int k, int n){
		List<List<Integer>> result = new ArrayList<>();
		backtracking3(result, new ArrayList<Integer>(), k, n, 1);
		return result;
	}

	public static void backtracking3(List<List<Integer>> result, ArrayList<Integer> currentList, int k, int target, int start){
		if(currentList.size() > k) return;
		else if(currentList.size() == k && target == 0){
			result.add(new ArrayList<>(currentList));
		}else{
			for(int i = start; i <= 9; i++){
				currentList.add(i);
				backtracking3(result, currentList, k, target-i, i+1);
				currentList.remove(currentList.size()-1);
			}
		}
	}
}
