import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAllAnagramsInAString {

    // public static List<Integer> findAnagrams(String s, String p) {
    // int[] pMap = new int[26];
    // for (char ch : p.toCharArray()) {
    // pMap[ch-'a']++;
    // }
    // List<Integer> list = new ArrayList<>();

    // for (int i = 0; i < s.length()-p.length()+1; i++) {
    // if (pMap[s.charAt(i)-'a']!=0) {
    // if (isAnagram(pMap, s.substring(i,i+p.length()))) {
    // list.add(i);
    // }
    // }
    // }
    // return list;

    // }

    // public static boolean isAnagram(int[] pMap, String s) {
    // int[] map = new int[26];
    // for (char ch : s.toCharArray()) {
    // map[ch-'a']++;
    // }
    // for (char ch : s.toCharArray()) {
    // if(map[ch-'a']!=pMap[ch-'a']) {
    // return false;
    // }
    // }
    // return true;
    // }

    // public static List<Integer> findAnagrams(String s, String p) {
    //     HashMap<Character, Integer> pMap = new HashMap<>();

    //     for (char ch : p.toCharArray()) {
    //         if (!pMap.containsKey(ch)) {
    //             pMap.put(ch, 1);
    //         } else {
    //             pMap.put(ch, pMap.get(ch) + 1);
    //         }
    //     }
    //     List<Integer> list = new ArrayList<>();

    //     for (int i = 0; i < s.length() - p.length() + 1; i++) {
    //         if (pMap.containsKey(s.charAt(i))) {
    //             HashMap<Character, Integer> map = new HashMap<>();
    //             for (char ch : s.substring(i, i + p.length()).toCharArray()) {
    //                 if (!map.containsKey(ch)) {
    //                     map.put(ch, 1);
    //                 } else {
    //                     map.put(ch, map.get(ch) + 1);
    //                 }
    //             }
    //             boolean isAnagram = true;
    //             for (char ch : s.substring(i, i + p.length()).toCharArray()) {
    //                 if (!pMap.containsKey(ch) || map.get(ch) != pMap.get(ch)) {
    //                     isAnagram = false;
    //                     break;
    //                 }
    //             }
    //             if (isAnagram) {
    //                 list.add(i);
    //             }

    //         }
    //     }
    //     return list;

    // }

    // Solution 2 
    public static List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
       List<Integer> result = new ArrayList<>();
       
       for(int i=0;i<p.length();i++){
           map[p.charAt(i) - 'a']++;
       }
   
       int windowStart = 0;
       int windowEnd = 0;
       while(windowEnd<s.length()){
       // valid anagram
           if(map[s.charAt(windowEnd) - 'a'] > 0){
               map[s.charAt(windowEnd++) - 'a']--;
           // window size equal to size of P
               if(windowEnd-windowStart ==  p.length()){                    
                   result.add(windowStart);
               }
           }
           // window is of size 0
           else if(windowStart == windowEnd){
               windowStart ++;
               windowEnd ++;
           }
           // decrease window size
           else{
               map[s.charAt(windowStart++) - 'a']++;
           }      
       }
       return result;

   }


    public static boolean isAnagram(int[] pMap, String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (map[ch - 'a'] != pMap[ch - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List list = findAnagrams("abab", "ab");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
