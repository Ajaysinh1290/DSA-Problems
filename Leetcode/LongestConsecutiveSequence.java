// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        // First we will add all nums in set
        for (int num : nums)
            set.add(num);

        int count = 0;
        for (int num : nums) {

            // if num-1 will already available then we will skip this iteration
            if (set.contains(num - 1))
                continue;

            int newCount = 1;

            while (set.contains(++num)) {
                newCount++;
                // we will remove the num from set so when all numbers are counted then we can
                // break loop
                set.remove(num);
            }
            count = Math.max(newCount, count);
            if (set.isEmpty())
                break;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1 };  
        int result = longestConsecutive(nums);
        System.out.println("Result is " + result);
    }
}
