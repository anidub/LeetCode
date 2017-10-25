package Numbers;

import java.util.ArrayList;
import java.util.List;
/*
 * Description: Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its
 * missing ranges.
 * <p/>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * <p/>
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-missing-ranges
 * 
 * https://discuss.leetcode.com/topic/18612/accepted-java-solution-with-explanation
 * Time complexity : O(N)
 */
public class MissingRanges {

	public static void main(String[] args) {
		int[] arr = {0, 1, 3, 50, 75};
		List<String> result = getMissingRange(arr, 0, 99);
		for(String s : result)
			System.out.println(s);

	}

	public static List<String> getMissingRange(int[] arr, int low, int high){
		List<String> result = new ArrayList<>();
		 // the next number we need to find
		int next = low;
		for(int i = 0; i < arr.length; i++){
			 // not within the range yet
			if(arr[i] < next) continue;
			
			 // continue to find the next one
			if(arr[i] == next){
				next++;
				continue;
			}
			 // get the missing range string format
			result.add(getNextRange(next, arr[i] - 1));
			  // now we need to find the next number
			next = arr[i] + 1;			
		}
		// do a final check
		if(next <= high)
			result.add(getNextRange(next, high));
		
		return result;
	}
	
	public static String getNextRange(int n1, int n2){
		return n1 == n2 ? String.valueOf(n1) : String.format("%d-%d", n1,n2);
	}
}
