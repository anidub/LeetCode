package Strings;

import java.util.Arrays;
import java.util.HashMap;
/*
 * Check if two given strings are isomorphic to each other
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to every character of str2. 
And all occurrences of every character in ‘str1’ map to same character in ‘str2’
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
 * Input:  str1 = "aab", str2 = "xxy"
	Output: True
	'a' is mapped to 'x' and 'b' is mapped to 'y'.
 * Time Complexity :  O(n) 
 */
public class isoMorphicStrings {

	static int size = 256;
	public static void main(String[] args) {
		boolean res = areIsomorphic("aab", "xxy");
        System.out.println(res);
	}
	
	public static boolean areIsomorphic(String a, String b){
		int m = a.length();
		int n = b.length();
		if(m != n) return false;
		
		Boolean[] marked = new Boolean[size];
		Arrays.fill(marked, false);
		
		int[] map = new int[size];
		Arrays.fill(map, -1);
		
		for(int i = 0; i < n; i++){
			if(map[a.charAt(i)] == -1){
				
				if(marked[b.charAt(i)] == true)
					return false;
				marked[b.charAt(i)] = true;
				
				map[a.charAt(i)] = b.charAt(i);
			}else if(map[a.charAt(i)] != b.charAt(i))
				return false;
		}
		return true;
	}
	
	public boolean isIsomorphic(String s, String t) {
	    if(s==null || t==null)
	        return false;
	 
	    if(s.length() != t.length())
	        return false;
	 
	    HashMap<Character, Character> map = new HashMap<Character, Character>();
	    for(int i = 0; i < s.length(); i++){
	        char c1 = s.charAt(i);
	        char c2 = t.charAt(i);
	 
	        if(map.containsKey(c1)){
	            if(map.get(c1)!=c2)// if not consistant with previous ones
	                return false;
	        }else{
	            if(map.containsValue(c2)) //if c2 is already being mapped
	                return false;
	            map.put(c1, c2);
	        }
	    }	 
	    return true;
	}
}
