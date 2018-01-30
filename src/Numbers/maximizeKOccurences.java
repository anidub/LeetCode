package Numbers;
/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class maximizeKOccurences {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		removeDuplicates(nums);

	}
	  public static int removeDuplicates(int[] nums) {
	        return removeDuplicates(nums, 2);
	    }
	    
	    public static  int removeDuplicates(int[] nums, int k) {	        
	        int len = nums.length, count = 1;
	        // j points the position where the next qualified number 
	        // found by i pointer will be written
	        for ( int i = 1, j = 1; i < nums.length; i++ ) {

	            count = (nums[i] != nums[i-1]) ? 1 : count+1;
	            
	            if ( count > k ) {
	                len--;
	            } else {
	                nums[j++] = nums[i];
	            }

	        }
	        return len;
	    }
}