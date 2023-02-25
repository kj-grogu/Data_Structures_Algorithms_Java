public class Numberof1Bits {
// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/

// Write a function that takes the binary representation of an unsigned integer and 
// returns the number of '1' bits it has (also known as the Hamming weight).

// Example 1:

// Input: n = 00000000000000000000000000001011
// Output: 3
// Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

	 // you need to treat n as an unsigned value
    // public int hammingWeight(int n) {
    //   //System.out.println("n: "+ n);
    //   String nToStrBinary = Integer.toBinaryString(n);
    //   //System.out.println("nToStrBinary: "+ nToStrBinary);
    //   int count = 0;
    //     for(int i=0; i< nToStrBinary.length(); i++){
    //       if(nToStrBinary.charAt(i) == '1')
    //          count++;
    //     }
    //   return count;
    // }
  //do using bit operations
  public static int hammingWeight(int n) {
    int count = 0;  
    while(n != 0){
      //using left shift (strictly O(logN))
      // count += n & 1;
      // n = n >>> 1;
      //OR
      //counts only 1s (worst case O(logN), best case O(1))
      n &= n-1;
      count++;
    }
    return count; 
  }
  public static void main(String [] args){
	int n = 55;
	System.out.println("no of 1 bits is/are: " + hammingWeight(n));
  }
}
