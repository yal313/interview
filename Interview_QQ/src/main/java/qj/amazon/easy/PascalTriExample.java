package qj.amazon.easy;

import java.util.Arrays;
import java.util.List;

public class PascalTriExample {

	public static void main(String[] args) {
		getRow1(4);

	}
	
	public static List<Integer> getRow(int rowIndex) {
		Integer[] result =  new Integer[rowIndex + 1];
	      Arrays.fill(result, 0);
	      result[0] = 1;
	      for(int i = 1; i < rowIndex + 1; i++)
	        for(int j = i; j >= 1; j--)
	          result[j] += result[j - 1];
	      return Arrays.asList(result);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Integer> getRow1(int k){
		Integer[] list = new Integer[k+1];
		Arrays.fill(list, 0);
		list[0]=1;
		for(int i = 1; i < k+1; i++){
			for(int j = i; j >=1; j--){
				list[j] = list[j] + list[j-1];
			}
		}
		
		return Arrays.asList(list);
	}

}
