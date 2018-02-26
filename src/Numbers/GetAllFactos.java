package Numbers;

import java.util.ArrayList;
import java.util.List;
/*
 * https://www.programcreek.com/2014/07/leetcode-factor-combinations-java/
 * 8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
 */
public class GetAllFactos {

	public static void main(String[] args) {
		getFactors(8);
	}

	public static List<List<Integer>> getFactors(int n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		getFactors(2, 1, n, result, current);
		return result;
	}
	
	public static void getFactors(int start, int product, int n, List<List<Integer>> result, List<Integer> current){
		if(start > n || product > n) return;
		
		if(product == n){
			List<Integer> temp = new ArrayList<>(current);
			result.add(temp);
			return;
		}
		for(int i = start; i < n; i++){
			if(i * product > n)
				break;
			if(n % i == 0){
				current.add(i);
				getFactors(i, i * product, n, result, current);
				current.remove(current.size() - 1);
			}
		}
	}
}
