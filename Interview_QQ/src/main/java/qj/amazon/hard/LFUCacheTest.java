package qj.amazon.hard;

public class LFUCacheTest {
	public static void main(String[] args){
		LFUCache cache = new LFUCache(2);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.get(1);       // returns 1
		cache.set(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(1); 
		cache.get(3); 
		cache.get(3); 
		cache.get(3); 
		cache.get(1); 
		cache.get(3);       // returns 3.
		cache.set(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}
}
