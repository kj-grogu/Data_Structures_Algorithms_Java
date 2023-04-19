public class TwoSumIntegers {
// 	371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/
// Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

// Example 1:

// Input: a = 1, b = 2
// Output: 3
// Example 2:

// Input: a = 2, b = 3
// Output: 5
 

// Constraints:

// -1000 <= a, b <= 1000


	public static int getSum(int a, int b) {
// 		int i = 0;
// 		if(a<0){
// 		  while(a!=0){
// 			i--;
// 			a++;
// 		  }
// 		}
// 		else{
// 		  while(a!=0){
// 			i++;
// 			a--;
// 		  }
// 		}
		
// 		if(b<0){
// 		  while(b!=0){
// 			i--;
// 			b++;
// 		  }
// 		}
// 		else{
// 		  while(b!=0){
// 			i++;
// 			b--;
// 		  }
// 		}
//   return i; 

  //Solution using bitwise operators (& , ^): https://www.youtube.com/watch?v=gVUrDV4tZfY
  while(b != 0){
	int temp = (a & b) << 1;
	a = a ^ b;
	b = temp;
}
return a;
}

public static void main(String [] args){
	int a = -10, b = -8;
	System.out.println("addition result is: "+ getSum(a,b));
}
}
