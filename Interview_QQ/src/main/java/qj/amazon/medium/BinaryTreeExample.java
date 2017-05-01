package qj.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeExample {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t5 = new TreeNode(5);
		t5.left = t7;
		t5.right = t8;
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		t2.left = t4;
		t2.right = t5;
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t6 = new TreeNode(6);
		t6.left = t9;
		t6.right = t10;
		TreeNode t3 = new TreeNode(3);
		t3.left = t6;
		root.left = t2;
		root.right = t3;
		List<Integer> list1 = boundaryOfBinaryTree(root);
		for(Integer n: list1){
			System.out.println(n);
		}
		
		System.out.println("-----------------");
		
		TreeNode root1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		root1.left=a2;
		List<Integer> list2 = rightSideofTree(root1);
		for(Integer n: list2){
			System.out.println(n);
		}
		System.out.println("-----------------");
		List<List<Integer>> list3 = levelOrder(root);
		for(List<Integer> list: list3){
			for(int n: list){
				System.out.println(n);
			}
			System.out.println(".....");
		}
		System.out.println("-----------------");
		System.out.println(isValidBST(root));
		System.out.println(isValidBST(root1));
		TreeNode root2 = new TreeNode(1);
		TreeNode a3 = new TreeNode(2);
		root2.right=a3;
		System.out.println(isValidBST(root2));
		
		System.out.println("-----------------");
		String s = "4(2(3)(1))(6(5))";
		TreeNode tn = str2tree1(s);
		
		System.out.println("-----------------");
		System.out.println(serialize(root));
		String s1 = "3,2,1,4,5,6,7,8,9,10";
		//TreeNode tn1 = deserialize(s1);
		
		Stack<Integer> stack = new Stack<>();
	}
	
	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null) return null;
        List<Integer> treeId = new ArrayList<Integer>();
        treeId.add(root.val);
        leftBoundary(treeId, root.left);
        leaves(treeId,root.left);
        leaves(treeId, root.right);
        rightBoundary(treeId, root.right);
        
        return treeId;
    }

	private static void rightBoundary(List<Integer> treeId, TreeNode node) {
		if(node == null || (node.left == null && node.right == null)){
			return;
		}
		if(node.right==null){
			rightBoundary(treeId, node.left);
		}
		else{
			rightBoundary(treeId, node.right);
		}
		treeId.add(node.val);
		
	}

	private static void leaves(List<Integer> treeId, TreeNode node) {
		if(node == null) return;
		if(node.left == null && node.right == null){
			treeId.add(node.val);
			return;
		}
		leaves(treeId, node.left);
		leaves(treeId, node.right);
		
	}

	private static void leftBoundary(List<Integer> treeId, TreeNode node) {
		if(node == null || (node.left == null && node.right == null)){
			return;
		}
		treeId.add(node.val);
		if(node.left==null){
			leftBoundary(treeId, node.right);
		}
		else{
			leftBoundary(treeId, node.left);
		}
		
	}
	
	public static List<Integer> rightSideofTree(TreeNode root){
		if(root == null){
			return new ArrayList<Integer>();
		}
		
		List<Integer> rightNodes = new ArrayList<Integer>();
		rightSide(rightNodes, root, 0);
		return rightNodes;
	}

	private static void rightSide(List<Integer> rightNodes, TreeNode root, int currDepth) {
		if(root==null ){
			return;
		}
		if(currDepth == rightNodes.size()){
			rightNodes.add(root.val);
		}
		
		rightSide(rightNodes, root.right, currDepth+1);
		rightSide(rightNodes, root.left, currDepth+1);
		
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        level(map, root, 0);
        
        return new ArrayList<List<Integer>>(map.values());
    }
	
	public static void level(Map<Integer, List<Integer>>map, TreeNode root, int currDepth){
		if(root == null){
			return;
		}
		if(!map.containsKey(currDepth)){
			map.put(currDepth, new ArrayList<Integer>());
		}
		map.get(currDepth).add(root.val);

		level(map, root.left, currDepth+1);
		level(map, root.right,currDepth+1);
	}
	
	public static boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
        
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	private static boolean validate(TreeNode root, long min, long max) {
		if(root == null){
			return true;
		}
		if(root.val < min || root.val > max){
			return false;
		}
		
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
		
	}
	
	public static TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')'){
            	stack.pop();
            }
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'){
                	i++;
                }
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null){ 
                    	parent.right = currentNode;
                    }
                    else{
                    	parent.left = currentNode;
                    }
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }	
	
	public static TreeNode str2tree1(String s) {
		if(s==null || s.length() == 0){
            return null;
        }
        
        char[] c = s.toCharArray();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<String> extra = new Stack<String>();
        for(int i = 0; i < c.length; i++){
            if(c[i] >= '0' && c[i] <='9' || c[i] == '-'){
                if(i + 1 < c.length && (c[i+1] >= '0' && c[i+1] <='9' || c[i+1] == '-')){
                    StringBuffer sb1 = new StringBuffer();
                    if(!extra.isEmpty()){
                        sb1.append(extra.pop());
                    }
                    sb1.append(String.valueOf(c[i]));
                    extra.push(sb1.toString());
                    continue;
                }
                StringBuffer sb = new StringBuffer();
                while(!extra.isEmpty()){
                    sb.append(extra.pop());
                }
                sb.append(String.valueOf(c[i]));
                TreeNode node = new TreeNode(Integer.valueOf(sb.toString()));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left==null){
                        parent.left = node;
                    }
                    else{
                        parent.right = node;
                    }
                }
                stack.push(node);
            }
            else if(c[i] == ')'){
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()){
            return stack.pop();
        }
        return null;
	}
	
	private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            //sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
            sb.append(node.val).append(spliter);
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
	
}
