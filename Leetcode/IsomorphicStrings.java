import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

    // Solution - 1

    // public static boolean isIsomorphic(String s, String t) {

    // HashMap<Character, ArrayList<Integer>> sMap = new HashMap<>();
    // HashMap<Character, ArrayList<Integer>> tMap = new HashMap<>();

    // for (int i = 0; i < s.length(); i++) {
    // {
    // char ch = s.charAt(i);
    // if (sMap.containsKey(ch)) {
    // sMap.get(ch).add(i);
    // } else {
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(i);
    // sMap.put(ch, list);
    // }
    // }
    // {
    // char ch = t.charAt(i);
    // if (tMap.containsKey(ch)) {
    // tMap.get(ch).add(i);
    // } else {
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(i);
    // tMap.put(ch, list);
    // }
    // }
    // }
    // for (int i = 0; i < s.length(); i++) {
    // char sChar = s.charAt(i);
    // char tChar = t.charAt(i);
    // if(!sMap.get(sChar).equals(tMap.get(tChar))) {
    // return false;
    // }

    // }
    // return true;
    // }

    //Solution 2 

    // public static boolean isIsomorphic(String s, String t) {
    //     HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
    //     HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
    //     StringBuilder sStr = new StringBuilder("");
    //     StringBuilder tStr = new StringBuilder("");

    //     for (int i = 0; i < s.length(); i++) {
    //         {
    //             char sChar = s.charAt(i);
    //             if (sMap.containsKey(sChar)) {
    //                 sStr.append(" " + sMap.get(sChar));
    //             } else {
    //                 sMap.put(sChar, i);
    //                 sStr.append(" " + i);
    //             }
    //         }
    //         {
    //             char tChar = t.charAt(i);
    //             if (tMap.containsKey(tChar)) {
    //                 tStr.append(" " + tMap.get(tChar));
    //             } else {
    //                 tMap.put(tChar, i);
    //                 tStr.append(" " + i);

    //             }
    //         }
    //     }
    //     System.out.println("Sstr : "+sStr);
    //     System.out.println("Tstr : "+tStr);
    //     return tStr.compareTo(sStr)==0;
    // }

    public static boolean isIsomorphic (String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
        
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
     
        return true;
    }

    public static void main(String[] args) {
        boolean result = isIsomorphic("foo", "agg");
        System.out.println("result is " + result);
    }
}
