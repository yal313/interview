package qj.amazon.easy;

public class MinStackExample {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(3);
		obj.push(-31);
		obj.push(3);
		obj.push(-3);
		obj.push(9);
		obj.push(3);
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());

	}

}
