package qj.amazon;

public class LinkedListSample {

	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode l3 = addTwoNumbers1(l1, l2);
		ListNode l4 = addTwoNumbers2(l1, l2);
		ListNode l5 = addTwoNumbers3(l1, l2);
		while(l3!=null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
		while(l5!=null){
			System.out.println(l5.val);
			l5 = l5.next;
		}
		ListNode l6 = addTwoNumbersReverse(l1, l2);
		while(l6!=null){
			System.out.println(l6.val);
			l6 = l6.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode tail = l3;
		ListNode c1 = l1;
		ListNode c2 = l2;
		int sum = 0;
		while(c1!=null || c2!=null){
			sum = sum/10;
			System.out.println("sum " + sum);
			if(c1!=null){
				sum += c1.val;
				c1 = c1.next;	
			}
			if(c2 !=null){
				sum += c2.val;
				c2 = c2.next;
			}
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
		}
		
		if(sum/10 == 1){
			tail.next = new ListNode(1);
		}		
		
		return l3.next;
		
    }
	
	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		long start = System.nanoTime();
		ListNode l3 = new ListNode(0);
		ListNode tail = l3;
		ListNode c1 = l1;
		ListNode c2 = l2;
		
		int sum = 0;
		while (c1!=null || c2!=null){		
			//carry
			sum = sum/10;
			if(c1!=null){
				sum = sum + c1.val;
				c1 = c1.next;
			}
			if(c2!=null){
				sum = sum + c2.val;
				c2 = c2.next;
			}
			tail.next = new ListNode(sum%10);
			tail = tail.next;		
		}
		
		if(sum/10 == 1){
			tail.next = new ListNode(1);
		}
		System.out.println(System.nanoTime()-start);
		return l3.next;
	}
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		long start = System.nanoTime();
        ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    System.out.println(System.nanoTime()-start);
	    return dummyHead.next;
    }
	
	public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		long start = System.nanoTime();
        ListNode dummyHead = new ListNode(0);
	    ListNode p = l1;
	    ListNode q = l2; 
	    ListNode curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	    	int x = 0;
	    	int y = 0;
	    	int sum = 0;
	    	if(p!=null){
	    		x = p.val;
	    		p = p.next;
	    	}
	    	if(q !=null){
	    		y = q.val;
	    		q = q.next;
	    	}
	    	sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    System.out.println(System.nanoTime()-start);
	    return dummyHead.next;
    }
	
	public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
		ListNode b1 = reverse(l1);
		ListNode b2 = reverse(l2);
		
		ListNode l3 = new ListNode(0);
		ListNode current = l3;
		int carry = 0;
		while(b1!=null || b2!=null){
			int x = 0;
			int y = 0;
			int sum = 0;
			if(b1!=null){
				x=b1.val;
				b1 = b1.next;
			}
			if(b2!=null){
				y=b2.val;
				b2 = b2.next;
			}
			sum = carry + x + y;
			carry = sum/10;
			current.next = new ListNode(sum%10);
			current = current.next;
		}
		if(carry>0){
			current.next = new ListNode(1);
		}
		return l3.next;
	}
	
	//set next = current.next: take all element from node besides the first element 
	//eg. node={2,4,3}
	//next={4,3}
	//current={2}
	//prev={2}
	//current={4,3}
	//second time while loop
	//next={3}
	//current={4,2}
	//prev={4,2}
	//current={3}
	//third time while loop
	//next=null
	//current={3,4,2}
	//prev={3,4,2}
	//current=null
	//basically: if it is {1,2,3,4}
	//take 2, put 1 -> {2,1}
	//take 3, put {2,1} -> {3,2,1}
	//take 4, put {3,2,1} -> {4,3,2,1}
	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
	
}

