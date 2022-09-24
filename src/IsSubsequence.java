public class IsSubsequence {
    //392. Is Subsequence
    //https://leetcode.com/problems/is-subsequence/
//     Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
// of the characters without disturbing the relative positions of the remaining characters. 
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false
 

// Constraints:

// 0 <= s.length <= 100
// 0 <= t.length <= 104
// s and t consist only of lowercase English letters.
 

// Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
    
public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        int ptrS = 0;
        int ptrT = 0;
        while(ptrS <= ptrT && ptrS < sArr.length && ptrT < tArr.length)
        {
            if(sArr[ptrS] == tArr[ptrT]){
                ptrS++;
                ptrT++;
            }else{
                ptrT++; 
            }
        }
        if(ptrS == sArr.length)
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";
        isSubsequence(s,t);
    }
}
