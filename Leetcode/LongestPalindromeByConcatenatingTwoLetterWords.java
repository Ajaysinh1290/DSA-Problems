
//  https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromeByConcatenatingTwoLetterWords {

  
    public static int optLongestPalindrome(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> m = new HashMap();
        int unpaired = 0, ans = 0;
        for (String w: words) {
            if (!m.containsKey(w)) m.put(w, 0);
            if (w.charAt(0) == w.charAt(1)) {
                if (m.get(w) > 0) {
                    unpaired--;
                    m.put(w, m.get(w) - 1);
                    ans += 4;
                }
                else {
                    m.put(w, m.get(w) + 1);
                    unpaired++;
                }
            }
            else {
                String rev = Character.toString(w.charAt(1)) + 
                    Character.toString(w.charAt(0));
                if (m.containsKey(rev) && m.get(rev) > 0) {
                    ans += 4;
                    m.put(rev, m.get(rev) - 1);
                }
                else m.put(w, m.get(w) + 1);
            }
            System.out.println(Arrays.asList(m));

    
        }
        if (unpaired > 0) ans += 2;
        return ans;
    }
    
    public static void main(String[] args) {
        String[] words = {
                "qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of" };
        int result = optLongestPalindrome(words);
        System.out.println("Result is " + result);
    }
}
