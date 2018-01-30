package Numbers;

/*
 * http://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * Find duplicates in O(n) time and O(1) extra space | Set 1
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers 
appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

Time:O(N)
Space : O(1)
 */
public class findDuplicatesInArray {

	public static void main(String[] args) {
		int[] arr = {1, 6, 3, 1, 3, 6, 6};
		findDup(arr);
	}	
	
	public static void findDup(int[] arr){
		int n = arr.length;
		for(int i = 0; i < arr.length; i++){
			int index = arr[i] % n;
			arr[index] += n; 
		}
		for(int i = 0; i < arr.length; i++){
			if(arr[i]/n > 1)
				System.out.println("index :" + i);
		}
	}
}
