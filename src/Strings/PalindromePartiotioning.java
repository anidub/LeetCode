package Strings;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/palindrome-partitioning/discuss/
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * 
 * https://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/ ->used this
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 *  time complexity O(n^3)

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class PalindromePartiotioning { 
	
	public static void main(String[] args) {
		String str = "nitin";
		partition(str);
	}
	
	public static List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> curList = new ArrayList<>();
		backtrack(s, 0,result, curList);
		
		for(List<String> list : result){
			for(String string : list){
				System.out.print(string + " ");
			}
			System.out.println();
		}
		return result;
	}
	
	public static void backtrack(String s, int start, List<List<String>> result,  List<String> curList){
		if(start == s.length()){
			ArrayList<String> temp = new ArrayList<String>(curList);
			result.add(temp);
			return;
		}
		for(int i = start+1; i <= s.length(); i++){
			String str = s.substring(start, i);
			if(isPalindrome(str)){
				curList.add(str); 
				backtrack(s, i, result, curList);
				curList.remove(curList.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String str){
		int left = 0;
		int right = str.length() - 1;
	 
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) return false;
			left++;
			right--;
		}	 
		return true;
	}
}