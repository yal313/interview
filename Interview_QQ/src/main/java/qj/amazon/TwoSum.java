package qj.amazon;
import java.util.HashMap;
import java.util.Map;
//o(n)
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
        int temp = 0;
    	int temp1 = 0;
    	int[] result = new int[2];
        for(int i = 0; i< nums.length-1; i++){
        	temp = nums[i];
        	result[0] = i;
        	for(int j = i+1; j< nums.length; j++){
        		temp1 = nums[j];
        		if((temp + temp1) == target){
        			result[1] = j;
        			return result;
        		}
        	}
        }
        return null;
    }
    
    public static void main(String[] args){
    	int[] intArray = new int[] {2,5,5,11};
    	long start = System.nanoTime();
    	int[] result = twoSum1(intArray, 10);
    	System.out.println(System.nanoTime()-start);
    	long start1 = System.nanoTime();
    	int[] result1 = twoSum(intArray, 10);
    	System.out.println(System.nanoTime()-start1);
    	
    	for(int i = 0; i < result.length; i++){
    		System.out.println(result[i]);
    	}
    }
    
    public static int[] twoSum1(int[] numbers, int target) {
    	
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	System.out.println(target - numbers[i]);
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
            System.out.println(numbers[i]+ "   " + (i));
        }
        
        return result;
    }
}
