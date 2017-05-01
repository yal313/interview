package qj.amazon.easy;

public class MaxProfitStockExample {

	public static void main(String[] args){
		int[] p = {1,4,2,-6,2,-4,5};
		System.out.println(maxProfit(p));
	}
	
	public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
