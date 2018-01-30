package Strings;

public class nextClosestTime {

	/*no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, “01:34”, “12:09” are all valid. “1:34”, “12:9” are all invalid.
Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
	 * https://discuss.leetcode.com/topic/104863/6ms-java-solution
	 * Time complexity : O(4 * 4 * 4 * 4) solution
	 */
	public static void main(String[] args) {
		System.out.println(getNextClosestTime("01:12"));
	}

	public static String getNextClosestTime(String time){
		int[] digits = new int[4];
		digits[0] = time.charAt(0) - '0';
		digits[1] = time.charAt(1) - '0';
		digits[2] = time.charAt(3) - '0';
		digits[3] = time.charAt(4) - '0';
		int givenT = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
		int min = 100000;
		int minH = 0; int minM = 0;
		
		for(int i = 0; i < digits.length; i++){
			if(digits[i] > 2) continue;
			
			for(int j = 0; j < digits.length; j++){
				int h = digits[i] * 10 + digits[j];
				if(h >= 24) continue;
				
				for(int k = 0; k < digits.length; k++){
					if(digits[k] >= 6) continue;
					
					for(int l = 0; l < digits.length; l++){
						int m = digits[k] * 10 + digits[l];
						int currentT = h * 60 + m;
						int diff = currentT - givenT;
						/*int diff = givenT - currentT;*/ //if you want previous closest time
						if(diff <= 0)
							diff += 24 * 60;
						
						if(diff < min){
							min = diff;
							minH = h;
							minM = m;
						}
					}
				}
			}
		}
		
		return (minH < 10 ? "0" + minH : ""+ minH ) + ":" + (minM < 10 ? "0" + minM : "" + minM);
	}
}