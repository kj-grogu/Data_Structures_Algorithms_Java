import java.util.*;
// 443. String Compression
//https://leetcode.com/problems/string-compression/

// Given an array of characters chars, compress it using the following algorithm:

// Begin with an empty string s. For each group of consecutive repeating characters in chars:

// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// After you are done modifying the input array, return the new length of the array.

// You must write an algorithm that uses only constant extra space.

public class StringCompression {
	public static int compress(char[] chars) {
        if(chars.length == 1)
            return 1;
        int i=0;
        int j=0;
        int curr = 0;
        while(i < chars.length){
            j=i;
            while(j < chars.length){
                if(chars[i]!=chars[j])
                    break;
                j++;
            }
            if(i+1 == j){
                chars[curr] = chars[i];
                i = j;
                curr++;
                continue;
            }    
            else{
                int var = j-i;
                //System.out.println("i: "+ i + " j: "+ j + " var: "+ var + " curr: " + curr);
                if(var >= 10){
                    chars[curr] = chars[i];
                    curr++;
                    List<Integer> nums = new ArrayList<>();
                    while(var / 10 != 0){
                        nums.add(var % 10);
                        var = var / 10;
                    }
                    nums.add(var);
                    for(int k=nums.size() - 1; k>=0; k--){
                        chars[curr] = (char)('0' + nums.get(k));
                        curr++;
                    }
                }
                else{
                    chars[curr] = chars[i];
                    curr++;
                    chars[curr] = (char)('0' + var);
                    curr++;
                }
            }
            if(j == chars.length)
                break;
            i = j;
        }
        return curr;
    }
	public static void main(String [] args){
		char [] chars = {'a','a','b','b','c','c','c'};
		System.out.println("compressed string is: "+ compress(chars));
	}
}
