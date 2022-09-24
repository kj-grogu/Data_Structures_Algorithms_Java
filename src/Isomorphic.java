import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
     //205. Isomorphic Strings
    // https://leetcode.com/problems/isomorphic-strings/
//     Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true
 

// Constraints:

// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.
    
public static boolean isIsomorphic(String s, String t) {
    //Solution that works but is built with less of logic
    // char [] sArr = s.toCharArray();
    // char [] tArr = t.toCharArray();
//         if(sArr.length < 1 || sArr.length > 50000 || sArr.length != tArr.length)
//             return false;
    
//         Map<Character,String> mapMatchSameCharsIndS = new LinkedHashMap<>();
//         Map<Character,String> mapMatchSameCharsIndT = new LinkedHashMap<>();
    
//         for(int i=0; i < sArr.length; i++){
//             if(mapMatchSameCharsIndS.containsKey(sArr[i])){
//                 mapMatchSameCharsIndS.put(sArr[i], mapMatchSameCharsIndS.get(sArr[i]) + ',' + i);
//             }else{
//                 String temp = i+"";
//                 mapMatchSameCharsIndS.put(sArr[i],temp);    
//             }
//             if(mapMatchSameCharsIndT.containsKey(tArr[i])){
//                 mapMatchSameCharsIndT.put(tArr[i], mapMatchSameCharsIndT.get(tArr[i]) + ',' + i);
//             }else{
//                 String temp = i+"";
//                 mapMatchSameCharsIndT.put(tArr[i],temp);    
//             }
//         }
//          String valMap1 = mapMatchSameCharsIndS.values().toString();
//          String valMap2 = mapMatchSameCharsIndT.values().toString();
//         // System.out.println(valMap1 + " " + valMap2);
    
//         System.out.println(mapMatchSameCharsIndS);
//         System.out.println(mapMatchSameCharsIndT);
    
//         return valMap1.equals(valMap2);

//*************************************Logically better solution************************************************
//             char [] sArr = s.toCharArray();
//             char [] tArr = t.toCharArray();
//         if(sArr.length < 1 || sArr.length > 50000 || sArr.length != tArr.length)
//              return false;
    
//          Map<Character,Character> mapStoT = new HashMap<>();
//          Map<Character,Character> mapTtoS = new HashMap<>();
    
//          for(int i=0; i<sArr.length; i++){
//              if(mapStoT.containsKey(sArr[i])){
//                  if(mapTtoS.containsKey(mapStoT.get(sArr[i])) && mapTtoS.get(mapStoT.get(sArr[i])) != sArr[i]){
//                      return false; 
//                  }
//              }
//              else
//              {
//                 if(mapTtoS.containsKey(tArr[i]) && mapTtoS.get(tArr[i]) != sArr[i])
//                     return false;
//                 mapStoT.put(sArr[i],tArr[i]);
//              }
//              if(mapTtoS.containsKey(tArr[i])){
//                  if(mapStoT.containsKey(mapTtoS.get(tArr[i])) && mapStoT.get(mapTtoS.get(tArr[i])) != tArr[i]){ 
//                         return false;  
//                  }
//              }
//              else
//              {
//                 if(mapStoT.containsKey(sArr[i]) && mapStoT.get(sArr[i]) != tArr[i])
//                     return false;
//                 mapTtoS.put(tArr[i],sArr[i]);
//              }
             
//          }
//          System.out.println("mapStoT: "+ mapStoT);
//          System.out.println("mapTtoS: "+ mapTtoS);
    
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    
    for(int i = 0; i < s.length(); i++){
        char cs = s.charAt(i);
        char ct = t.charAt(i);
        
        // new mapping 
        if(!map1.containsKey(cs) && !map2.containsKey(ct)){
            map1.put(cs, ct);
            map2.put(ct, cs);
        }
        // verify char matches to old mapping 
        else if(map1.containsKey(cs) && map2.containsKey(ct)){
            if(map1.get(cs) != ct || map2.get(ct) != cs)
                return false;
        }
        
        // either of a char is missing or already mapped so return false
        else
            return false;
    }
     return true;
}
public static void main(String[] args) {
    String s = "bbbaaaba";
    String t = "aaabbbba";
    isIsomorphic(s,t);
}
}
