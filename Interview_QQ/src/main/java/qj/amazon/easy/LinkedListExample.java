package qj.amazon.easy;

import java.util.ArrayList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(10);
		l1.next.next.next.next = new ListNode(2);
		l1.next.next.next.next.next = new ListNode(1);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(10);
		l2.next.next.next.next = new ListNode(2);
		l2.next.next.next.next.next = new ListNode(1);
		
		ListNode x = getIntersection(l1, l2);
		ListNode c = getIntersectionNode(l1,l2);
		
		//hascycle
		ListNode r = new ListNode(1);
		r.next = new ListNode(6);
		r.next.next = new ListNode(7);
		r.next.next.next = new ListNode(8);
		r.next.next.next.next = new ListNode(6);
		r.next.next.next.next.next = new ListNode(9);
		r.next.next.next.next.next.next = new ListNode(10);
		r.next.next.next.next.next.next.next = new ListNode(9);
		r.next.next.next.next.next.next.next.next= new ListNode(6);
		
		ListNode r1 = new ListNode(1);
		r1.next = new ListNode(6);
		r1.next.next = new ListNode(7);
		System.out.println( hasCycle(r));
		System.out.println( hasCycle(r1));
		
		//palidrown
		ListNode r2 = new ListNode(1);
		r2.next = new ListNode(6);
		r2.next.next = new ListNode(7);
		r2.next.next.next = new ListNode(8);
		r2.next.next.next.next = new ListNode(9);
		r2.next.next.next.next.next = new ListNode(8);
		r2.next.next.next.next.next.next = new ListNode(7);
		r2.next.next.next.next.next.next.next = new ListNode(6);
		r2.next.next.next.next.next.next.next.next= new ListNode(1);
		System.out.println(isPalindrome(r2));
		System.out.println(isPalindrome1(r2));
		
		ListNode r3 = new ListNode(-129);
		r3.next = new ListNode(-129);
		System.out.println(isPalindrome(r3));
		System.out.println(isPalindrome1(r3));
		
	}
	
	public static ListNode getIntersection(ListNode headA, ListNode headB){
		long start = System.nanoTime();
		if(headA == null || headB == null){
			return null;
		}
		
		ListNode a = headA;
		ListNode b = headB;
		ListNode c = null;
		
		while(a!=null && b!=null){
			if(a.val == b.val){
				if(checkEqual(a.next, b.next)){
					c = a;
					System.out.println(System.nanoTime()-start);
					return c;
				}
			}
			else if(a.val < b.val){
				a = a.next;
			}
			else{
				b = b.next;
			}
		}
		System.out.println(System.nanoTime()-start);
		return null;
	}
	
	public static boolean checkEqual(ListNode a, ListNode b){
		if(a == null && b == null){
			return true;
		}
		if(a.val == b.val){
			return checkEqual(a.next, b.next);
		}
		return false;
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		long start = System.nanoTime();
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    System.out.println(System.nanoTime()-start);
	    return headA;
	}

	private static int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
	
	public static boolean hasCycle(ListNode head) {
	    if(head==null) return false;
	    ListNode walker = head;
	    ListNode runner = head;
	    while(runner.next!=null && runner.next.next!=null) {
	        walker = walker.next;
	        runner = runner.next.next;
	        if(walker.val==runner.val) return true;
	    }
	    return false;
	}
	
	public static boolean isPalindrome(ListNode head) {
		long start = System.nanoTime();
		if(head == null){
			return true;
		}
        List<Integer> list = toArray(head);
        for(int i = 0; i < list.size()/2+1; i++){
            if(list.get(i).intValue()!=list.get(list.size()-1-i).intValue()){
            	return false;
            }
        }
        System.out.println(System.nanoTime()-start);
        return true;
    }
    
    public static List<Integer> toArray(ListNode head){
        ListNode a = head;
        List<Integer> list = new ArrayList<Integer>();
        while(a!=null){
            list.add(a.val);
            a=a.next;
        }
        return list;
    }
	
    public static boolean isPalindrome1(ListNode head) {
    	long start = System.nanoTime();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(System.nanoTime()-start);
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
	
}
