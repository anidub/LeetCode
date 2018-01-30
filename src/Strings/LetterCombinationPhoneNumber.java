package Strings;

import java.util.LinkedList;
import java.util.List;
/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/
 */
public class LetterCombinationPhoneNumber {

	public static void main(String[] args) {
		letterCombinations("233");
		printCombos(new int[] { 2, 3, 4 });
	}

	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (digits.length() == 0) {
			return ans;
		}
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

	// http://www.geeksforgeeks.org/find-possible-words-phone-digits/
	// TC:Time Complexity: Time complexity of above code is O(4n) where n is
	// number of digits in input number
	public static void printCombos(int[] digits) {
		char[] result = new char[digits.length + 1];
		getCombos(digits, 0, result);
	}

	static String[] table = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void getCombos(int[] digits, int curDigit, char[] result) {
		int i;
		if (curDigit == digits.length) {
			for (char c : result)
				System.out.print(c);
			System.out.println();
			return;
		}

		for (i = 0; i < table[digits[curDigit]].length(); i++) {
			result[curDigit] = table[digits[curDigit]].charAt(i);
			getCombos(digits, curDigit + 1, result);
			if (digits[curDigit] == 0 || digits[curDigit] == 1)
				return;
		}
	}
}


