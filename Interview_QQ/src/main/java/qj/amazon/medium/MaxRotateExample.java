package qj.amazon.medium;

public class MaxRotateExample {

	public static void main(String[] args) {
		int[] A = {4, 3, 2, 6};
		System.out.println(maxRotateFunction(A));

	}
	
	 public static int maxRotateFunction(int[] A) {
	     if(A.length==0){
	    	 return 0;
	     }
	     
	     int sum = 0;
	     int F = 0;
	     for(int i = 0; i < A.length; i++){
	    	 sum = sum + A[i];
	    	 F = F + i * A[i];
	     }
	     
	     int max = F;
	     for(int i = 1; i < A.length; i++){
	    	 F = F - sum + A[i-1]*A.length;
	    	 max = Math.max(max, F);
	     }
	     
	     return max;
	     
	 }
	 

}
