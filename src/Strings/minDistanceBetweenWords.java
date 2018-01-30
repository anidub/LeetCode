package Strings;
/*
 * https://www.careercup.com/question?id=6051601991073792
 * Find minimum distance between two words (order preserved) in a big string. 
For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
e.g 2. "hello how are hello you" - distance is 1 
e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 */
public class minDistanceBetweenWords {

	public static void main(String[] args) {
		String str = "you are hello";
		System.out.println(findMinDistance(str, "hello", "you"));
	}
	
	public static int findMinDistance(String str, String source, String dest){
		if(str == null || source == null || dest == null) return -1;
		int minDist = Integer.MAX_VALUE;
		
		String[] arr = str.toLowerCase().split(" ");
		int sourceIndex = -1; int destIndex = -1;
		int i = 0;
		for(String s : arr){
			if(s.equals(source)){
				sourceIndex = i;
			}
			
			if(s.equals(dest)){
				destIndex = i;
			}
			if(sourceIndex != -1 && destIndex != -1){
				minDist = Math.min(minDist, Math.abs(destIndex - sourceIndex));
			}
			i++;
		}
		if(sourceIndex == -1 || destIndex == -1) return -1;
		else return minDist;
	}

}
