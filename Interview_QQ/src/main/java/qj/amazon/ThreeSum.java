package qj.amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
		int[] numbers1 = new int[]{0,0,0};
		int[] numbers2 = new int[]{-2,0,1,1,2};
		//List<List<Integer>> list = threeSum(numbers);
		List<List<Integer>> list1 = threeSum1(numbers);
		for(List<Integer> li: list1){
			for(Integer i: li){
				System.out.println(i);
			}
		}
		
		//List<List<Integer>> list2 = threeSum(numbers);
		List<List<Integer>> list3 = threeSum1(numbers1);
		for(List<Integer> li: list3){
			for(Integer i: li){
				System.out.println(i);
			}
		}

	}

	public static List<List<Integer>> threeSum1(int[] nums) {
    	long start = System.nanoTime();
        Arrays.sort(nums);
        List<Integer> innerList = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length-2; i++){
        	if(nums[i] > 0) break;
        	if(i > 0 && nums[i]==nums[i-1]) continue;
        	int lo = i + 1, hi = nums.length-1, sum = 0-nums[i];
        	while(lo < hi){
        		if(nums[lo]+nums[hi]==sum){
        			innerList = Arrays.asList(nums[i],nums[lo],nums[hi]);
    				list.add(innerList);
    				while(lo<hi && nums[lo]==nums[lo+1]){
    					lo++;
    				}
    				while(lo<hi && nums[hi]==nums[hi-1]){
    					hi--;
    				}
    				hi--;
    				lo++;
        		}
        		else if(nums[lo] + nums[hi]<sum){
        			while(lo<hi && nums[lo]==nums[lo+1]){
    					lo++;
    				}
        			lo++;
        		}
        		else{
        			while(lo<hi && nums[hi]==nums[hi-1]){
    					hi--;
    				}
        			hi--;
        		}
        	}
        }
        System.out.println(System.nanoTime()-start);
        return list;
    }
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	long start = System.nanoTime();
        int temp;
        int temp1;
        List<Integer> innerList = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length>=3){
	        for(int i = 0; i < nums.length-2; i++){
	        	temp = nums[i];
	        	for(int j = i+1; j<nums.length-1; j++){
	        		temp1 = nums[j];
	        		for(int k = j+1;k<nums.length; k++){
	        			if((temp + temp1 + nums[k]) == 0){
	        				innerList = new ArrayList<Integer>();
	        				innerList.add(temp);
	        				innerList.add(temp1);
	        				innerList.add(nums[k]);
	        				Comparator<Integer> comparator = (i1, i2) ->i1-i2;       				
	        				innerList.sort(comparator);
	        				if(!list.contains(innerList)){
	        					list.add(innerList);
	        				}
	        			}
	        		}
	        	}
	        	
	        }
        }
        System.out.println(System.nanoTime()-start);
        return list;
    }

}
