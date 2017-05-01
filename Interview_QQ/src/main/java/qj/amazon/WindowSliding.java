package qj.amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WindowSliding {
	public static void main(String[] args){
		int[] a = new int[]{1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] b = maxSlidingWindowMax(a, 3);
		System.out.println(Arrays.toString(b));
		
		int[] c = maxSlidingWindowMin(a, 3);
		System.out.println(Arrays.toString(c));
		
		int[] d = maxSlidingWindowSum(a, 3);
		System.out.println(Arrays.toString(d));
		
		int[] e = slidingWindowSum(a,3);
		System.out.println(Arrays.toString(e));
	}
	
	public static int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
	
	public static int[] maxSlidingWindowMax(int[] a, int k) {	
		//if a is empty or k <=0, exit
		if(a == null || k <= 0){
			return new int[0];
		}
		
		int length = a.length;
		int[] r = new int[length-k+1];
		int count = 0;
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 0; i < length; i++){
			//if there is element in the queue that does not belong to this set
			//remove it from head
			//eg. queue.peekFirst()=0
			//i=3, i-k+1=1, 0<1, does not belong to the second set
			while(!queue.isEmpty() && queue.peekFirst()<i-k+1){
				queue.pollFirst();
			}
			
			while(!queue.isEmpty() && a[queue.peekLast()] < a[i]){
				queue.pollLast();
			}
			
			queue.offer(i);
			if(i>=k-1){
				r[count] = a[queue.peekFirst()];
				count++;
			}
		}
		return r;
		
	}
	
	public static int[] maxSlidingWindowMin(int[] a, int k) {
		long start = System.nanoTime();
		if(a == null || k <= 0){
			return new int[0];
		}
		
		int length = a.length;
		int[] r = new int[length-k+1];
		int count = 0;
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 0; i<length; i++){
			while(!queue.isEmpty()&& queue.peekFirst()<i-k+1){
				queue.pollFirst();
			}
			
			while(!queue.isEmpty() && a[queue.peekLast()] > a[i]){
				queue.pollLast();
			}
			
			queue.offer(i);
			if(i>=k-1){
				r[count] = a[queue.peekFirst()];
				count++;
			}
		}
		System.out.println(System.nanoTime()-start);
		return r;
	}
	
	public static int[] maxSlidingWindowSum(int[] a, int k) {
		long start = System.nanoTime();
		if(a == null || k <=0){
			return new int[0];
		}
		
		int length = a.length;
		int[] r = new int[length-k+1];
		int count = 0;
		
		for(int i = 0; i < length - k + 1; i++){
			int c = 0;
			int sum = 0;
			while(c < k){
				sum = sum + a[i+c];
				c++;
			}
			r[count] = sum;
			count++;
		}
		System.out.println(System.nanoTime()-start);
		return r;
	}
	
	public static int[] slidingWindowSum(int num[], int window_size){
		long start = System.nanoTime();
        // initialize result
        int sums[] = new int[Math.max(num.length-window_size+1,1)];
        // check if window_size is greater than num[] size, return -1
        if(window_size > num.length) sums[0] = -1;
        // current sum, function as a window
        int cur_sum = 0; 
        // go through num[]
        for(int i = 0, j = 0;i < num.length;i++){
            // each time a new number come, add to window
            cur_sum += num[i];
            if(i >= window_size-1){
                // if not the start window, delete the first one from window
                if(i-window_size >= 0) cur_sum -= num[i-window_size];
                // set window(cur_sum) to output
                sums[j++] = cur_sum;
            }
        }
        System.out.println(System.nanoTime()-start);
        return sums;
    }
}
