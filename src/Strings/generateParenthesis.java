package Strings;

import java.util.ArrayList;
import java.util.List;
/*
 * https://discuss.leetcode.com/topic/36057/easy-java-solution
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class generateParenthesis {

	public static void main(String[] args) {
		generateParenthesis(3);
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			return res;
		}
		helper(res, "", n, n);
		return res;
	}
	
	private static void helper(List<String> res, String present, int left, int right) {
		if (right == 0) res.add(present);
		if (left > 0) {
			helper(res, present + "(", left - 1, right);
		}
		if (right > left) {
			helper(res, present + ")", left, right - 1);
		}
	}
	
}