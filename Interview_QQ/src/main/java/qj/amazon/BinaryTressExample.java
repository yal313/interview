package qj.amazon;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class BinaryTressExample {

	public static void main(String[] args) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(3);
		DefaultMutableTreeNode t1 = new DefaultMutableTreeNode(2);
		t1.add(new DefaultMutableTreeNode(7));
		t1.add(new DefaultMutableTreeNode(4));
		DefaultMutableTreeNode t2 = new DefaultMutableTreeNode(5);
		t2.add(new DefaultMutableTreeNode(6));
		t2.add(t1);
		DefaultMutableTreeNode t3 = new DefaultMutableTreeNode(1);
		t3.add(new DefaultMutableTreeNode(0));
		t3.add(new DefaultMutableTreeNode(8));
		root.add(t2);
		root.add(t3);
		
		TreeNode t = lowestCommonAncestor(root, new DefaultMutableTreeNode(5), new DefaultMutableTreeNode(1));

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null ||root ==p || root == q){
        	return root;
        }
        
        return null;
    }
}
