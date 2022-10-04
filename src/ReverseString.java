public class ReverseString {
// 	344. Reverse String
//https://leetcode.com/problems/reverse-string/
// Easy

// 6145

// 1001

// Add to List

// Share
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

 

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
 

// Constraints:

// 1 <= s.length <= 105
// s[i] is a printable ascii character.
	public static void reverseString(char[] s) {
        char temp;
        for (int i=0,j=s.length - 1;i<s.length/2;i++,j--)
        {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            System.out.println("["+i+"]-->"+s[i]+" s["+j+"]-->"+s[j]);
        }
    }
	public static void main(String[] args) {
		char [] s = {'h','e','l','l','o'};
		reverseString(s);
	}
}
