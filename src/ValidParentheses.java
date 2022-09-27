import java.util.Stack;

public class ValidParentheses {
    //20. Valid Parentheses
    //https://leetcode.com/problems/valid-parentheses/
//     Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

    public static boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(strArr[0]);
        for(int i=1;i<strArr.length;i++){
            if(!stack.isEmpty() && ((stack.peek() == '(' && strArr[i] == ')') ||
               (stack.peek() == '{' && strArr[i] == '}') || 
               (stack.peek() == '[' && strArr[i] == ']'))){
                stack.pop();
            }else
            stack.push(strArr[i]);          
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    } 
    public static void main(String[] args) {
        String str = "{{{{}}}}]";
        System.out.println("isValid ==> "+ isValid(str));
    }   
}
