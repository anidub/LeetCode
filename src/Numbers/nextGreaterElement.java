package Numbers;
/*
 * given a target and a sorted array, find the element that is strictly larger than the target. i.e. {a,c,d,e} b output: c
 */
public class nextGreaterElement {
/*
 * https://stackoverflow.com/questions/6553970/find-the-first-element-in-a-sorted-array-that-is-greater-than-the-target
 */
	public static void main(String[] args) {
		int arr[] = { 12, 15, 54, 221, 712 };
		nextGreater(arr, 71);
	}

	
	public static int nextGreater(int[] arr, int target){
		int low = 0;
		int high = arr.length;
		while(low <= high){
			int mid = low + (high-low)/2;
			if(arr[mid] <= target){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		if(low >= arr.length){
			System.out.println("-1");
		} else {
			System.out.println("Immediate next low : " + arr[high]);
			System.out.println("Immediate next high : " + arr[low]);
		}
		return -1;
	}
}
