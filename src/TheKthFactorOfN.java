public class TheKthFactorOfN {
// 1492. The kth Factor of n
// https://leetcode.com/problems/the-kth-factor-of-n/
// You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
// Consider a list of all factors of n sorted in ascending order, 
// return the kth factor in this list or return -1 if n has less than k factors.

	public static int kthFactor(int n, int k) {
        int fCount = 0;
        for(int i=1; i<=n/2; i++){
            if(n % i == 0){
                fCount++;
            }
            if(fCount == k)
                return i;
        }
        if(fCount + 1 == k)
            return n;
        return -1;
    }
	public static void main(String [] args){
		int n=12;
		int k=3;
		System.out.println("kth factor of "+ n +": " + kthFactor(n,k));
	}
}
