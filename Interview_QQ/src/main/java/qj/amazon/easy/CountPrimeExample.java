package qj.amazon.easy;

public class CountPrimeExample {

	public static void main(String[] args) {
		int i = 25; 
		System.out.println(countPrimes1(i));

	}
	
	public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
	
	public static int countPrimes1(int n){
		//declare array of booleans with size n
		//representing the state of each number

		boolean[] notPrime = new boolean[n];
		
		int count = 0;
		//start with 2, mark multiple of 2 to be not prime, then next loop will skip it
		for(int i = 2; i < n; i++){
			if(!notPrime[i]){
				count++;
				for(int j = 2; i*j < n; j++){
					notPrime[i*j] = true;
				}
			}
		}
		
		return count;
	}

}
