package qj.amazon.hard;

import java.util.Stack;

public class TinyURLExample {

	public static void main(String[] args) {
		int n = 125;
		System.out.println(encode(n));

		System.out.println(decode(encode(n)));
	}
	
	public static final char[] map={'q','w','e','r','t','y','u','i','o','p','a',
			's','d','f','g','h','j','k','l','z','x','c','v','b',
			'n','m','0','1','2','3','4','5','6','7','8','9','Q','W','E','R','T',
			'Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C',
			'V','B','N','M'};
	
	public static String encode(int id){
		Stack<Integer> stack = new Stack<Integer>();
		int n = id;
		while(n!=0){
			stack.push(n%62);
			n=n/62;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(map[stack.pop()]);
		}
		
		return sb.toString();
	}
	
	public static long decode(String s){
		char[] c = s.toCharArray();
		long id = 0;
		for(int i = 0; i < c.length; i++){
			id = id*62+getCharIndex(c[i]);
		}
		return id;
	}
	
	private static int getCharIndex(char c){
		for(int i = 0; i < map.length; i++ ){
			if(c == map[i]){
				return i;
			}
		}
		return -1;
	}

}
