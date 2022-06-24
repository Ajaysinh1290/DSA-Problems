// https://leetcode.com/problems/is-subsequence/

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original 
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {

    
    //Solution 1 
    // public static boolean isSubsequence(String s, String t) {
    //     String str = t;
    //     for(int i=0; i<s.length(); i++) {
    //         if(str.contains(s.charAt(i)+"")) {
    //             str = str.substring(str.indexOf(s.charAt(i))+1, str.length());
    //             System.out.println("Str is "+str);
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //Solution 2 Time complexity O(n)
    public static boolean isSubsequence(String s, String t) {
        if(t.isEmpty()) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(i)==t.charAt(count)) count++;
            if(count==s.length()) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean result  =  isSubsequence("aaaaaa","bbaaaa");
        System.out.println("Result is "+result);
    }
}
