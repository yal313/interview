package qj.amazon.easy;

public class ReapeatedStringExample {

	public static void main(String[] args){
		String s = "abcabcabcabcabcabcabc";
		System.out.println(repeatedSubstringPattern1(s));
	}
	
	public static boolean repeatedSubstringPattern(String str) {
		int l = str.length();
		for(int i=l/2;i>=1;i--) {
			if(l%i==0) {
				int m = l/i;
				String subS = str.substring(0,i);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<m;j++) {
					sb.append(subS);
				}
				if(sb.toString().equals(str)) return true;
			}
		}
		return false;
	}
	
	public static boolean repeatedSubstringPattern1(String s) {
		int length = s.length();
		for(int i = length/2; i > 0; i--){
			if(length%i == 0){
				int m = length/i;
				String s1 = s.substring(0,i);
				StringBuffer sb = new StringBuffer();
				for(int j = 0; j < m; j++){
					sb.append(s1);
				}
				if(sb.toString().equals(s)){
					return true;
				}
			}
		}
		return false;
    }
}
