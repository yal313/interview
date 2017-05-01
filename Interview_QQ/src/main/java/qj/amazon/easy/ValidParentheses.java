package qj.amazon.easy;

import java.util.Stack;

//Stack is a subclass of Vector that implements a 
//standard last-in, first-out stack.
//Example: 
//stack: []
//stack.push(2) --> stack:[2]
//stack.push(5) --> stack:[2,5]
//stack.push(9) --> stack:[2,5,9]
//stack.pop() --> stack: [2,5]
//stack.pop() --> stack: [2]
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(){}[]";
		String s1 = "({])";
		System.out.println(isValid1(s));
		System.out.println(isValid1(s1));
		
	}
	
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray()){
			if(c=='('){
				stack.push(')');
			}
			else if(c == '{'){
				stack.push('}');
			}
			else if (c == '['){
				stack.push(']');
			}
			else if (stack.empty() || stack.pop()!=c){
				return false;
			}
		}	
		return stack.empty();
	}
	
	public static boolean isValid1(String s){
		Stack<Character> stack = new Stack<Character>();
		
		for(char c: s.toCharArray()){
			if(c == '('){
				stack.push(')');
			}
			else if (c == '{'){
				stack.push('}');
			}
			else if (c == '['){
				stack.push(']');
			}
			else if (stack.empty() || stack.pop()!=c){
				return false;
			}
		}
		
		return stack.empty();
	}
	

}
