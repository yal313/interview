package qj.amazon.easy;

public class ThirdMaxNumExample {

	public static void main(String[] args){
		int[] nums = new int[]{1,2,4,3,5};
		System.out.println(thirdMax(nums));
		int[] nums1 = new int[]{1,2};
		System.out.println(thirdMax(nums1));
	}
	
	public static int thirdMax(int[] nums) {
        Integer max1 = null; //maximum
        Integer max2 = null; //middle
        Integer max3 = null; //min in 3 maximum
        
        for(int n: nums){
        	if((max1!=null && n == max1) 
        			|| (max2!=null && n == max2) 
        			|| (max3!=null && n == max3)) continue;
        	if(max1 == null || n > max1){
        		max3 = max2;
        		max2 = max1;
        		max1 = n;
        	}
        	else if(max2 == null || n > max2){
        		max3 = max2;
        		max2 = n;
        	}
        	else if(max3 == null || n > max3){
        		max3 = n;
        	}
        }
        if(max3 !=null ){
        	return max3;
        }
        return max1;
    }
}
