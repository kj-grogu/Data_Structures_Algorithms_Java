// 7. Reverse Integer
//https://leetcode.com/problems/reverse-integer/

// Given a signed 32-bit integer x, return x with its digits reversed. 
//If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:
// Input: x = 123
// Output: 321

// Example 2:
// Input: x = -123
// Output: -321

// Example 3:
// Input: x = 120
// Output: 21
 
// Constraints:
// -231 <= x <= 231 - 1

//Logic: https://www.youtube.com/watch?v=HAgLH58IgJQ

public class  ReverseInteger {
	public static int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        int res = 0;
        int digit = 0;

        while(x != 0){
            digit = x % 10;
            x = x / 10;

            if(res > max / 10 || (res == max / 10 && digit >= max % 10))
                return 0;
            if(res < min / 10 || (res == min / 10 && digit <= min % 10))
                return 0;
            res = (res * 10) + digit;

        }
        return res;
    }

    public static void main(String [] args){
        //int x = 1534236469;
        int x = 123456789;
        System.out.println("the reverse of the number "+ x + " is: "+ reverse(x));

    }

}
