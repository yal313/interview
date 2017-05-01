package qj.amazon;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		matrix[0][0]=1;
		matrix[0][1]=2;
		matrix[0][2]=3;
		matrix[0][3]=4;

		matrix[1][0]=5;
		matrix[1][1]=6;
		matrix[1][2]=7;
		matrix[1][3]=8;
    	
		matrix[2][0]=9;
		matrix[2][1]=10;
		matrix[2][2]=11;
		matrix[2][3]=12;
    	
		matrix[3][0]=13;
		matrix[3][1]=14;
		matrix[3][2]=15;
		matrix[3][3]=16;
    	
		print(matrix);
		rotate(matrix);
		print(matrix);
		
		int[][] matrix1 = new int[4][4];
		matrix[0][0]=1;
		matrix[0][1]=2;
		matrix[0][2]=3;
		matrix[0][3]=4;

		matrix[1][0]=5;
		matrix[1][1]=6;
		matrix[1][2]=7;
		matrix[1][3]=8;
    	
		matrix[2][0]=9;
		matrix[2][1]=10;
		matrix[2][2]=11;
		matrix[2][3]=12;
    	
		matrix[3][0]=13;
		matrix[3][1]=14;
		matrix[3][2]=15;
		matrix[3][3]=16;
		
		print(matrix);
		antiClockRotate(matrix);
		print(matrix);
	}
	
	public static void print(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			System.out.println(matrix[i][0] + "  " +matrix[i][1] + "  "+matrix[i][2] + "  "+matrix[i][3] + "  ");
		}
	}
	
	public static void rotate(int[][] matrix) {
		//1 2 3
		//4 5 6
		//7 8 9
		//first transpose
		//2<->4
		//3<->7
		//6<->8
		//1 4 7
		//2 5 8
		//3 6 9
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j < matrix[0].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		//and then swap
		//1<->7
		//2<->8
		//3<->9
		//7 4 1
		//8 5 2
		//9 6 3
		int y = matrix[0].length;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < y/2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][y-1-j];
				matrix[i][y-1-j] = temp;
			}
		}
	}
	
	public static void antiClockRotate(int[][] matrix) {
		//1 2 3
		//4 5 6
		//7 8 9
		//first transpose
		//2<->4
		//3<->7
		//6<->8
		//1 4 7
		//2 5 8
		//3 6 9
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j < matrix[0].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		//and then swap
		//1<->3
		//4<->6
		//9<->7
		//3 6 9
		//2 5 8
		//1 4 7
		int x = matrix.length;
		for(int i = 0; i < x/2; i++){
			for(int j = 0; j < matrix[0].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[x-1-i][j];
				matrix[x-1-i][j] = temp;
			}
		}
	}

}
