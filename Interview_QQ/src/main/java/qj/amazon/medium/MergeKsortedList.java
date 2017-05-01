package qj.amazon.medium;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import qj.amazon.easy.ListNode;

public class MergeKsortedList {

	public static void main(String[] args) {
		ListNode r2 = new ListNode(1);
		r2.next = new ListNode(6);
		r2.next.next = new ListNode(7);
		r2.next.next.next = new ListNode(8);
		r2.next.next.next.next = new ListNode(9);

		ListNode r = new ListNode(1);
		r.next = new ListNode(6);
		r.next.next = new ListNode(7);
		r.next.next.next = new ListNode(8);
		r.next.next.next.next.next = new ListNode(9);
		r.next.next.next.next.next.next = new ListNode(10);

		
		ListNode[] list = {r,r2};
		ListNode l3 = mergeKLists(list);

	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
        	return null;
        }
        
        Comparator<ListNode> comparator = (n1, n2) -> {
        	if(n1.val < n2.val){
        		return -1;
        	}
        	else if(n1.val == n2.val){
        		return 0;
        	}
        	else{
        		return 1;
        	}
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, comparator);
        
        for(ListNode ll: lists){
        	if(ll!=null){
        		pq.add(ll);
        	}
        }
        
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(!pq.isEmpty()){
        	temp.next = pq.poll();
        	temp = temp.next;
        	
        	if(temp.next!=null){
        		pq.add(temp.next);
        	}
        }
        
        return head.next;
    }

}
