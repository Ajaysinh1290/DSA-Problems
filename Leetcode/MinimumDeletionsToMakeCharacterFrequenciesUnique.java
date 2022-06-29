// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

import java.util.Arrays;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {


    // Solution 1
    // public static int minDeletions(String s) {
    //     int[] array = new int[26];
    //     for (char c : s.toCharArray()) {
    //         array[c - 'a']++;
    //     }
    //     int deletions = 0;
    //     HashSet<Integer> set = new HashSet<Integer>();
    //     for (int value : array) {
    //         while (value != 0 && !set.add(value)) {
    //             value -= 1;
    //             deletions++;
    //         }
    //     }
    //     return deletions;
    // }

    // Solution 2
    public static int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0)
                break;
            if (freq[i] >= freq[i + 1]) {
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i + 1] - 1);
                ans += prev - freq[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = minDeletions("aaabbbccc");
        System.out.println(result);
    }
}
