package Strings;

/*
 * Replace String sequence using Recursion
 * https://stackoverflow.com/questions/14450938/replace-string-sequence-using-recursion
 */
public class replaceString {

	public static void main(String[] args) {
		String str = "Hello world";
		String pattern = "world";
		String replace = "earth";
		System.out.println(replace(str, pattern, replace));
	}
	
	public static String replace(String string, String pattern, String replacement){
		int index = indexOf(string.toCharArray(), pattern.toCharArray(),0);
		System.out.println(index);
		if(index < 0) return string;
		int endIndex = index + pattern.length();
		return string.substring(0,index) + replacement + replace(string.substring(endIndex),pattern, replacement);
	}
	
	static int indexOf(char[] string, char[] pattern, int startIndex) {
		int index = startIndex;
		while (true) {
			while (index < string.length && string[index] != pattern[0])
				index++;
			if (index >= string.length || index + pattern.length > string.length)
				return -1;
			boolean match = true;
			for (int i = 1; i < pattern.length; i++) {
				if (string[index + i] != pattern[i]) {
					match = false;
					break;
				}
			}
			if (match) return index;
			else
				index += 1;
		}
	}
}
