package qj.amazon.easy;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInArrayExample {

	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,4,5,2,6};
		System.out.println(findPairs(nums, 2));
	}
	
	public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int findPairs1(int[] nums, int k){
		if(nums == null || nums.length == 0 || k<0){
			return 0;
		}
		
		Map<Integer, Integer>map = new HashMap<Integer, Integer>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int[] count = {0};
		map.forEach((n,v) -> {
			if(k == 0){
				if(v>=2){
					count[0]++;
				}
			}
			else{
				if(map.containsKey(n+k)){
					count[0]++;
				}
			}
		});
		
		return count[0];
	}
}
