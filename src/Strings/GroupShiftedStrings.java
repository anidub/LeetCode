package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/*
 * Given a string, we can "shift" each of its letter to its successive letter, 
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:
 [
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
or
https://ide.geeksforgeeks.org/Mwz0B4
 */
public class GroupShiftedStrings {

	public static void main(String[] args) {
		String[] arr ={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		getGroups(arr);
	}
	
	public static List<List<String>> getGroups(String[] strings){
		List<List<String>> result = new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		if(strings == null) return result;
		for(String s : strings){
			char[] arr = s.toCharArray();
			int diff = arr[0] - 'a';
			for(int i = 0; i < arr.length; i++){
				if(arr[i] - diff < 'a'){
					arr[i] = (char) (arr[i] - diff + 26);
				}else{
					arr[i] = (char)(arr[i] - diff);
				}
			}
			String newString = new String(arr);
			if(map.containsKey(newString)){
				map.get(newString).add(s);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				map.put(newString, list);
			}
		}
		for(Entry<String, ArrayList<String>> entry: map.entrySet()){
			Collections.sort(entry.getValue());
			result.add(entry.getValue());
		}
		return result;		
	}
}