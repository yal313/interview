package qj.amazon.easy;

public class Merge2SortedListExample {

	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(10);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(14);
		
		ListNode l3 = mergeTwoLists(l1,l2);
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode merge;
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		
		if(l1.val < l2.val){
			merge = l1;
			merge.next = mergeTwoLists(l1.next,l2);
		}
		else{
			merge = l2;
			merge.next = mergeTwoLists(l1, l2.next);
		}
		
		return merge;
		
	}
}
