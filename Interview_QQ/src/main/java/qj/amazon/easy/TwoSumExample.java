package qj.amazon.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSumExample {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6,8};
		twoSum(nums,12);
		int[] nums1 = {1,2,3,4,6,8};
		twoSumSorted(nums1,12);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target-nums[i])){
				result[0] = i;
				result[1] = map.get(target - nums[i]);
				System.out.println(result[0]+ " "+result[1]);
				return result;
			}
			map.put(nums[i], i);
		}
		
		return result;
	}
	
	public static int[] twoSumSorted(int[] nums, int target) {

		int[] result = new int[2];
		int lo = 0;
		int hi = nums.length-1;
		while(lo < hi){
			if(nums[lo] + nums[hi] == target){
				result[0]=lo+1;
				result[1]=hi+1;
				System.out.println(result[0]+ " "+result[1]);
				return result;
			}
			else if(nums[lo] + nums[hi] < target){
				lo++;
			}
			else if(nums[lo] + nums[hi] > target){
				hi--;
			}
		}
		
		return result;
	}

}
