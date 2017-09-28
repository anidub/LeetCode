package Numbers;

public class reverseMatrix {

	public static void main(String[] args) {
		int[][] matrix = { {1,2,3}, {3,2,1}, {2,1,3} };
		reverseMatrix(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}
	
	public static void reverseMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			reverseArray(matrix[i]);
		}
	}
	
	private  static void reverseArray(int[] arr){
		for(int i = 0; i < arr.length/2; i++){
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length- i - 1] = temp;
		}
	}

}
