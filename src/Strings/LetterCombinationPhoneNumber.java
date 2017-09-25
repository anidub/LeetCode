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
	}
	
	 public static List<String> letterCombinations(String digits) {
		    LinkedList<String> ans = new LinkedList<String>();
		    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		    if (digits.length()==0){
		    	return ans;
		    }
		    ans.add("");
		    for(int i = 0; i < digits.length();  i++){
		        int x = Character.getNumericValue(digits.charAt(i));
		        while(ans.peek().length()==i){
		            String t = ans.remove();
		            for(char s : mapping[x].toCharArray())
		                ans.add(t+s);
		        }
		    }
		    return ans;
		}
	 }
