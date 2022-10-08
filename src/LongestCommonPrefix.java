public class LongestCommonPrefix {
	// 14. Longest Common Prefix
	//https://leetcode.com/problems/longest-common-prefix/
	// Write a function to find the longest common prefix string amongst an array of strings.
	
	// If there is no common prefix, return an empty string "".
	// Example 1:
	// Input: strs = ["flower","flow","flight"]
	// Output: "fl"
	// Example 2:
	
	// Input: strs = ["dog","racecar","car"]
	// Output: ""
	// Explanation: There is no common prefix among the input strings.
	 
	// Constraints:
	
	// 1 <= strs.length <= 200
	// 0 <= strs[i].length <= 200
	// strs[i] consists of only lowercase English letters.
	public static String longestCommonPrefix(String[] strs) {
        int smLength = Integer.MAX_VALUE;
        String smlStr = "";
        
       for(int i=0;i<strs.length;i++){
           if(strs[i].length() < smLength){
               smLength = strs[i].length();
               smlStr = strs[i];
           }      
       }
        char [] smStrCharAr = smlStr.toCharArray();
        int count = 0;
        String retStr = ""; 
        
        for(int j=0; j<smLength; j++){
            for(int k=0;k<strs.length;k++){
                char [] tempAr = strs[k].toCharArray();
                if(tempAr[j] == smStrCharAr[j])
                {
                    count++;
                }else
                    break;
            }
            if(count == strs.length){
                retStr = retStr + smStrCharAr[j];
                count = 0;
            }
                
            else
                return retStr;
        }
    return retStr;
    }	

public static void main(String[] args) {
	String [] strs = {"flower", "flow", "flight"};
	System.out.println(longestCommonPrefix(strs));
}
}
