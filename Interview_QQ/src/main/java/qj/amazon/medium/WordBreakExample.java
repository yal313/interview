package qj.amazon.medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreakExample {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> dict = new ArrayList<String>();
		
		dict.add("add");
		dict.add("ecyrt");
		dict.add("leet");
		dict.add("opop");
		dict.add("lee");
		dict.add("ks");
		dict.add("tco");
		dict.add("pl");
		dict.add("de");
		
		System.out.println(wordBreak(s, dict));

	}
	
	public static boolean wordBreak(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
            	//must satisfy 1. the starting character is true, and substring(j,i) matches
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
	
	public static boolean wordbreak1(String s, List<String> dict){
		boolean[] inDict = new boolean[s.length() +1];
		inDict[0] = true;
		
		for(int i = 1; i < s.length(); i++){
			for(int j = 0; j < i; j++){
				if(inDict[j] && dict.contains(s.substring(j, i))){
					inDict[i] = true;
					break;
				}
			}
		}
		return inDict[s.length()];
	}
}
