package Numbers;

import java.util.TreeSet;

public class kEmptySlots {
/*
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. 
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
Given an array flowers consists of number from 1 to N. Each number in the array represents the place 
where the flower will open in that day.
For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x,
 where i and x will be in the range from 1 to N.
Also given an integer k, you need to output in which day there exists two 
flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.
If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:

Input: 
flowers: [1,2,3]
k: 1
Output: -1

https://discuss.leetcode.com/category/1528/k-empty-slots
USE THIS FOR UNDERSTANDING: http://zxi.mytechroad.com/blog/simulation/leetcode-683-k-empty-slots/

SOLN : https://discuss.leetcode.com/topic/104738/java-accepted-solution/2
First understand the representation of array(non zero indexed)
[1,3,2] means on, day 1, flower will bloom at index 1.
On day 2, flower will bloom at index 3.
On day 3, flower will bloom at index 2.
So basically this array holds days as index, and value as position the flower will bloom.

This representation will make the problem simpler to understand now.
So now consider example - [4,1,3,5,2].
Day 1 : [0,0,0,B,0] - flower at index 4 bloom : setContains : [4]
Day 2 : [B,0,0,B,0] - flower at index 1 bloom : setContains : [1,4] : k = 2
Day 3 : [B,0,B,B,0] - flower at index 3 bloom : setContains : [1,3,4] : k = 1, k = 0
Day 4 : [B,0,B,B,B] - flower at index 5 bloom : setContains : [1,3,4,5] : k = 0
Day 5 : [B,B,B,B,B] - flower at index 2 bloom : setContains : [1,2,3,4,5] : k = 0

On day 2, when you add 1, set has [1,4]. This means that there are no flowers that bloom in between these two positions. (which is 2,3). So two flowers.(k=2)
On day 3, when you add 3, set has [1,3,4]. This means that there are no flowers that bloom in between 1-3, and 3-4. (k = 1, and k = 0)

Similarly on day 4, when you add 5, position to left is 4. So k = 0. and so on.

So every day when a flower blooms, we just need to find out it's left and right bloomed flowers. All the flowers in between is guaranteed to be no-bloom.

Definition of set.higher : Returns the least element in this set strictly greater than the given element, or null if there is no such element.
Definition of set.lower : Returns the greatest element in this set strictly less than the given element, or null if there is no such element

Time complexity : O(n logn)
 */
	public static void main(String[] args) {
		int[] flowers = {1,3,2};
		int k = 1;
		System.out.println(kEmptySlots(flowers,k));

	}
	
	public static int kEmptySlots(int[] flowers, int k){
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0; i < flowers.length; i++){
			int current = flowers[i];
			Integer next = set.higher(current);
			if(next != null && next - current == k + 1){
				return i+1;
			}
			Integer pre = set.lower(current);
			if(pre != null && current - pre == k + 1){
				return i+1;
			}
			set.add(current);
		}
		return -1;
	}
}