package qj.amazon;

import java.util.HashMap;
import java.util.Map;

public class RandomListNodeExample {

	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(2);
		l1.next = new RandomListNode(4);
		l1.next.next = new RandomListNode(3);
		l1.random = l1.next.next;
		l1.next.random = new RandomListNode(l1.label);
		l1.next.next.next = new RandomListNode(5);
		
		RandomListNode l3 = copyRandomList1(l1);
		while(l3!=null){
			System.out.println(l3.label);
			l3 = l3.next;
		}
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
            return null;
        }
        
        final Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            final RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        
        return map.get(head);
    }
	
	public static RandomListNode copyRandomList1(RandomListNode head) {
		
		if(head == null){
			return null;
		}
		
		RandomListNode l1 = head;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		//put every node in to map
		while(l1!=null){
			map.put(l1, new RandomListNode(l1.label));
			l1 = l1.next;			
		}
		
		//beacuse pass by reference
		//when setting newNode, v is set (next and random is added to v)
		//and then v is also referencing the value in map.get(key.next)
		//so both place are set
		for(Map.Entry<RandomListNode, RandomListNode> entry: map.entrySet()){
			RandomListNode newNode = entry.getValue();
			newNode.next = map.get(entry.getKey().next);
			newNode.random = map.get(entry.getKey().random);
		}
		
		//option2 with java 8
		/*map.forEach((p,v) -> {
			RandomListNode newNode = v;
			newNode.next = map.get(p.next);
			newNode.random = map.get(p.random);
		});*/
		
		return map.get(head);
		
	}
}
