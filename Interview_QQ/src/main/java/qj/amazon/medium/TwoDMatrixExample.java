package qj.amazon.medium;

public class TwoDMatrixExample {

	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15},
							{2,5,8,12,19},
							{3,6,9,16,22},
							{10,13,14,17,24},
							{18,21,23,26,30}};
		System.out.println(searchMatrix(matrix, 10));
		System.out.println(searchMatrix(matrix, 19));
		System.out.println(searchMatrix(matrix, 25));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
			return false;
		}
		int col = matrix[0].length-1;
		int row = 0;
		while(col >=0 && row < matrix.length){
			if(matrix[row][col] == target){
				return true;
			}
			else if (matrix[row][col] < target){
				row++;
			}
			else{
				col--;
			}
		}
		
		return false;
	}
}
