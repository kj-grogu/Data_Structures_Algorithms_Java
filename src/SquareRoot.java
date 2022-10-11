public class SquareRoot {
// 	69. Sqrt(x)
//https://leetcode.com/problems/sqrtx/
// Given a non-negative integer x, compute and return the square root of x.

// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

// Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

// Example 1:

// Input: x = 4
// Output: 2
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 
// Constraints:
// 0 <= x <= 231 - 1

		public static int mySqrt(int x) {
			 if(x == 1)
				 return x;
			 int sqrt = 0;
			 int left = 1;
			 int right = x;
			 int mid = 0; 
			
			while(left <= right){ 
				mid = left + (right - left)/2;
				if(mid  > (x / mid)){
					right = mid - 1;
				}else if(mid < (x / mid))
				{
					if(mid > sqrt){
						sqrt = mid;
					}
					left = mid + 1;
				}else
				   return mid; 
			 
			}
			return sqrt;
			
		}
	public static void main(String [] args){
		int sqrt = mySqrt(555);
		System.out.println("sqrt: "+ sqrt);
	}
}
