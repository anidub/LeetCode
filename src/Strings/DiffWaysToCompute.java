package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToCompute {
/*
 * Given a string of numbers and operators, return all possible results 
 * from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * 
 * Time Complexity: n!
 */
	public static void main(String[] args) {
		String input = "2*3-4*5";
		List<Integer> result = diffWaysToCompute(input);
		for(int i : result){
			System.out.print(i+" ");
		}
	}
	
	static Map<String, ArrayList<Integer>> map = new HashMap<>();
	
	public static List<Integer> diffWaysToCompute(String input){
		List<Integer> result = new ArrayList<>();
		if(input == null || input.length() == 0){
			result = map.get(input);
		}
		
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
				for (int v1 : leftList) {
					for (int v2 : rightList) {
						if(c == '+'){
							result.add(v1 + v2);
						}else if(c == '-'){
							result.add(v1-v2);
						}else if(c == '*'){
							result.add(v1*v2);
						}							
					}
				}
			}
		}
		
		if(result.isEmpty()){
			result.add(Integer.parseInt(input));
		}
		map.put(input, (ArrayList<Integer>) result);
		return result;
	}
}