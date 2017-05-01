package qj.amazon.hard;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {	
    
    int capacity, id;
    HashMap<Integer, Integer> hashMap, frequency;
    PriorityQueue<Cache> queue;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        id=0;
        hashMap=new HashMap<>();
        frequency=new HashMap<>();
        // sort by frequency and recentness
        queue =new PriorityQueue<>((o1,o2) -> {
        	if(o1.f==o2.f){
        		return o1.r-o2.r;
        	}
        	return o1.f-o2.f;
        });
    }
    
    public int get(int key) {
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            return hashMap.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity==0) return;
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            hashMap.put(key, value);
            return;
        }
        if (hashMap.size()==capacity) {
            Cache first= queue.poll(); // find the smallest one, and remove it
            hashMap.remove(first.key);
            frequency.remove(first.key);
        }
        hashMap.put(key, value);
        frequency.put(key, 1);
        queue.add(new Cache(key, 1, id));
    }
    
    private void update(int key) { // update the priority queue
        int f=frequency.get(key);
        frequency.put(key, f+1); // get and update the frequency
        Cache cache=new Cache(key, f+1, id); // make a new Cache
        // remove the member in queue, if its key equals to the current key.
        // Here, queue uses `equals()` to judge the equality
        queue.remove(cache); 
        queue.add(cache); // add the current Cache to the queue.
    }
}
