package qj.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramExample {

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(s);
		groupAnagrams1(s);
		groupAnagrams2(s);

	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		long start = System.nanoTime();
		Arrays.sort(strs);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s: strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String ss = String.valueOf(c);
			if(!map.containsKey(ss)){
				map.put(String.valueOf(ss), new ArrayList<String>());
			}
			map.get(ss).add(s);
		}
		List<List<String>> list = new ArrayList<List<String>>(map.values());
		System.out.println(System.nanoTime()-start);
		return list;
	}
	
	public static List<List<String>> groupAnagrams1(String[] strs) {
		long start = System.nanoTime();
		//Arrays.sort(strs);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s: strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String ss = String.valueOf(c);
			if(!map.containsKey(ss)){
				map.put(String.valueOf(ss), new ArrayList<String>());
			}
			map.get(ss).add(s);
		}
		List<List<String>> list = new ArrayList<List<String>>(map.values());
		System.out.println(System.nanoTime()-start);
		return list;
	}
	
	public static List<List<String>> groupAnagrams2(String[] strs) {
		long start = System.nanoTime();
		//Arrays.sort(strs);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s: strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String ss = String.valueOf(c);
			if(!map.containsKey(ss)){
				map.put(String.valueOf(ss), new ArrayList<String>());
			}
			map.get(ss).add(s);
		}
		
		for(String key: map.keySet()) {
			Collections.sort(map.get(key));
		}
		
		List<List<String>> list = new ArrayList<List<String>>(map.values());
		System.out.println(System.nanoTime()-start);
		return list;
	}

}
