package qj.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*Character data is represented in a computer by using standardized numeric codes which have been developed. 
The most widely accepted code is called the American Standard Code for Information Interchange ( ASCII). 
The ASCII code associates an integer value for each symbol in the character set, such as letters, digits, 
punctuation marks, special characters, and control characters. 
Some implementations use other codes for representing characters, 
but we will use ASCII since it is the most widely used. 
The ASCII characters and their decimal code values are shown in Table 4.2. 
Of course, the internal machine representation of characters is in equivalent binary form.*/
//'a' = 97
//'b' = 98
//'c' = 99
//therefore hash['a'] = hash[97]
//hash['b'] = hash[98]
//hash['c'] = hash[99]
public class AnagramHashTable {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		String s1 = "abab";
		String p1 = "ab";
		List<Integer> index = findAnagrams1(s,p);
		List<Integer> index1 = findAnagrams1(s1,p1);
		index.forEach(i -> System.out.println(i));
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		long start = System.nanoTime();
        int plength = p.length();
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        List<Integer> index = new ArrayList<Integer>();
        Map<char[], Integer> table = new HashMap<char[], Integer>();
        
        for(int i = 0; i < s.length()+1-plength; i++){
        	table.put(s.substring(i,i+plength).toCharArray(), i);
        }
        table.forEach((k,v) -> {
        	Arrays.sort(k);
        	if(String.valueOf(k).toString().equals(String.valueOf(pc).toString())){
        		index.add(v);
        		System.out.println(v);
        	}
        });
        
        System.out.println(System.nanoTime()-start);
        return index;
    }
	
	public static List<Integer> findAnagrams1(String s, String p){
		List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    
	    int[] hash = new int[256]; //character hash	  
	    //record each character in p to hash
	    //Eg.p=['a','b','c']
	    //hash['a']=hash[97]=1
	    //hash['b']=hash[98]=1
	    //hash['c']=hash[99]=1
	    //all the other remains 0
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    //two points, initialize count to p's length
	    //eg.p.length()=3, 3 chars 3 chars moving to right
	    //numMatches = number of matches. 
	    //numMatches = 1: only one character matches
	    //numMatches = 2: two character matches
	    int left = 0, right = 0, numMatches = 0;	    
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, increase the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right)] >= 1) {
	        	numMatches++;
	        }
	        hash[s.charAt(right)]--;
	        right++;	        
	        //when the count is p.length, means we found the right anagram
	        //then add window's left to result list
	        if (numMatches == p.length()) {
	            list.add(left);
	        }
	        //if we find the window's size equals to p, then we have to move "left" (narrow the window) 
	        //to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only decrease the numMatches if the character is in p (meaning it was increased before)
	        if (right - left == p.length() ) {	 
	        	//if < 0, meaning there is no match, count didn't get deduct 
	            if (hash[s.charAt(left)] >= 0) {
	            	numMatches--;
	            }
	            hash[s.charAt(left)]++;
	            left++;	        
	        } 
	    }
	        return list;
	}

}
