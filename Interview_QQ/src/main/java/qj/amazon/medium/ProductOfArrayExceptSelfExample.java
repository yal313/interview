package qj.amazon.medium;

import java.util.Arrays;

//result should be r1[]*r2[]
//r1={1, 				a[0], 		a[0]*a[1], 	a[0]*a[1]*a[2]}
//r2={a[1]*a[2]*a[3], 	a[2]*a[3], 	a[3], 		1}

public class ProductOfArrayExceptSelfExample {

	public static void main(String[] args) {
		int[] n = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(n)));
	}

	public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] productArray = new int[length];
        int[] p1 = new int[length];
        int[] p2 = new int[length];
        
        int pp1 = 1;
        for(int i = 0; i < length; i++){
        	p1[i] = pp1;
        	pp1 = pp1 * nums[i];
        }
        
        int pp2 = 1;
        for(int i = length-1; i >=0; i--){
        	p2[i] = pp2;
        	pp2 = pp2 * nums[i];
        }
        
        for(int i = 0; i < length; i++){
        	productArray[i] = p1[i]*p2[i];
        }
        
        return productArray;
    }
}
