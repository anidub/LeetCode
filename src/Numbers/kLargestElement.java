package Numbers;
/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60333/Concise-JAVA-solution-based-on-Quick-Select
 * The basic idea is to use Quick Select algorithm to partition the array with pivot:

Put numbers < pivot to pivot's left
Put numbers > pivot to pivot's right
Then

if indexOfPivot == k, return A[k]
else if indexOfPivot < k, keep checking left part to pivot
else if indexOfPivot > k, keep checking right part to pivot


Discard half each time: n+(n/2)+(n/4)…1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+…1=n-1.

Time complexity is O(n), but the worst time complexity is O(n^2).

 */
public class kLargestElement {

	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(kthLargest(arr, 2));
	}
	
	public static int kthLargest(int[] array, int k){
		if(array == null || array.length == 0)
			return Integer.MAX_VALUE;
		return findkthLargest(array, 0, array.length - 1, array.length-k);
	}
	
	public static int findkthLargest(int[] array, int start, int end, int k){
		if(start > end) return Integer.MAX_VALUE;
		
		int pivot = array[end];
		int left = start;
		for(int i = start; i <= end; i++){
			if(array[i] <= pivot){// Put numbers < pivot to pivot's left
				swap(array, left, i);
				left++;
			}
		}
		
		swap(array,left, end);// Finally, swap A[end] with A[left]
		
		if(left == k){
			return array[left];
		}else if(left < k){
			return findkthLargest(array, left+1, end, k);
		}else{
			return findkthLargest(array, start, left-1, k);
		}
	}
	
	public static void swap(int[] array, int start, int end){
		if(start > end) return;
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}
}