// https://leetcode.com/problems/longest-palindrome/

import java.util.HashMap;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int length =1;
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            int value = map.get(ch)+1;
            map.put(ch, value);
            if(value%2==0) {
                length+=2;
            }
        }
        return length>s.length()?s.length():length;
    }

    public static void main(String[] args) {

        int result = longestPalindrome("bb");
        System.out.println("Result is " + result);

    }
}
