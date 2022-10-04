public class ReveseStringWords {
// 	557. Reverse Words in a String III
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
// Easy

// 4161

// 210

// Add to List

// Share
// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "God Ding"
// Output: "doG gniD"
 

// Constraints:

// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.

	public static String reverseWords(String s) {
        if(s =="")
            return s;
        String [] strWordsList = s.split(" ");  
        String retStr = "";
        for(int i=0;i<strWordsList.length;i++){
            char [] strTemp = strWordsList[i].toCharArray();
            char temp = 0;
            for(int j=0,k=strTemp.length-1; j<k;j++,k--){
                temp = strTemp[j];
                strTemp[j] = strTemp[k];
                strTemp[k] = temp;
            }
            if(retStr == "")
                retStr = retStr + new String(strTemp);
            else
                retStr = retStr + " " + new String(strTemp);
        }  
        return retStr;
        
    }
	public static void main(String [] args){
		System.out.println(reverseWords("This String is to be reversed"));
	}
}
