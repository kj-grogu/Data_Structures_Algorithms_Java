class ValidAnagram {
// 	242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/
// Easy

// 7100

// 240

// Add to List

// Share
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

	public boolean isAnagram(String s, String t) {
        
	if(s.length() != t.length())
		return false;
	Map<Character, Integer> map = new HashMap<>();
	Map<Character, Integer> map2 = new HashMap<>();
	
	
	for(int i = 0 ; i < s.length(); i++){
		 if(!map.containsKey(s.charAt(i)))
			map.put(s.charAt(i), 0);
		map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
	}
	
	
	for(int i = 0 ; i < t.length(); i++){
		if(!map2.containsKey(t.charAt(i)))
			map2.put(t.charAt(i), 0);
		map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
	}
	
	
	System.out.println(map);
	System.out.println(map2);
	
	int kval, sval;
	for(char k : map.keySet()){
		if(!map2.containsKey(k)){
			System.out.println("absent at : "+ k);
			return false;
		}
		sval = map.get(k);
		kval = map2.get(k);
		if(sval != kval){
			System.out.println("mismAtch at : "+ k + " | "+ sval +"====" +kval);
			return false;
		}
			
	}
	
	
	return true;
	
//         char [] arr = new char[256];
	
//         for(int i = 0; i < s.length(); i++){
//             arr[s.charAt(i)]++;
//         }
	
//         for(int i = 0; i < t.length(); i++){
//             arr[t.charAt(i)]--;
//         }
	
//         for(int i = 0;i < arr.length; i++){
//             if(arr[i]!= 0)
//                 return false;
//         }
	
//         return true;
	
//         char [] sAr = s.toCharArray();
//         char [] tAr = t.toCharArray();
	
//         if(sAr.length != tAr.length)
//             return false;
	
//         Map<Character,Long> sMap = new HashMap<>();
//         Map<Character,Long> tMap = new HashMap<>();
	
//         for(int i=0;i<sAr.length;i++){
//                 sMap.put(sAr[i], sMap.getOrDefault(sAr[i], 0L) + 1);
//                 tMap.put(tAr[i], tMap.getOrDefault(tAr[i], 0L) + 1);
//         }
	
//         System.out.println(sMap.size());
//         System.out.println(tMap.size());
	
//         for (char ch : tMap.keySet())
//         {
//             if(sMap.containsKey(ch))
//             {
//                 if(sMap.get(ch) == tMap.get(ch))
//                     continue;
//                 else
//                     return false;
//             }
//             else
//                 return false;
//         }
//         return true;
}
}
