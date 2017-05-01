package qj.amazon;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args){
		String[] gameScores = new String[]{"1","4","5","+","4","8","x"};
		System.out.println(calculateScore(gameScores));
	}
	
	public static int calculateScore(String[] scores){
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < scores.length; i++){
			if(checkInteger(scores[i])){
				stack.push(Integer.valueOf(scores[i]));
			}
			else if(scores[i].equals("+")){
				if(i>=2){
					if(checkInteger(scores[i-1]) && checkInteger(scores[i-2]) ){
						stack.push(Integer.valueOf(scores[i-1])+Integer.valueOf(scores[i-2]));				
					}
					else if(checkInteger(scores[i-1])){
						stack.push(Integer.valueOf(scores[i-1]));				
					}
					else if(checkInteger(scores[i-2]) ){
						stack.push(Integer.valueOf(scores[i-2]));				
					}
				}
			}
			else if(scores[i].equals("x")){
				stack.pop();
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()){
			sum = sum + stack.pop();
		}
		
		return sum;
	}
	
	public static boolean checkInteger(String s){
		try{
			int i = Integer.valueOf(s);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	
	
}
