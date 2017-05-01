package qj.amazon.easy;

import java.util.ArrayList;
import java.util.List;

public class AnagramExample {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		String s1 = "abab";
		String p1 = "ab";
		List<Integer> index = findAnagram(s,p);
		index.forEach(i -> System.out.println(i));
		System.out.println("break");
		List<Integer> index1 = findAnagram(s1,p1);
		index1.forEach(i -> System.out.println(i));
	}
	
	public static List<Integer> findAnagram(String s, String k){
		int[] hash = new int[256];
	
		for(char c: k.toCharArray()){
			hash[c]++;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		char[] sc = s.toCharArray();
		int left = 0;
		int right = 0;
		int numMatches = 0;
		while(left <= right && right < sc.length){
			if(hash[sc[right]]>=1){
				numMatches++;
			}
			hash[sc[right]]--;
			right++;
			if(numMatches==k.length()){
				list.add(left);
			}
			
			if(right-left==k.length()){
				if(hash[sc[left]]>=0){
					numMatches--;
				}
				hash[sc[left]]++;
				left++;
			}
		}
		return list;
	}
}
