// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

    // Solution 1 using median
    // public static int minMoves2(int[] nums) {
    //     Arrays.sort(nums);
    //     int median = nums[nums.length / 2];
    //     int move = 0;
    //     for (int num : nums) {
    //         move += Math.abs(median - num);
    //     }
    //     return move;
    // }

    // Optimized solution without using median
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j)
            res += nums[j--] - nums[i++];
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 10, 2, 9 };
        int result = minMoves2(nums);
        System.out.println(result);
    }
}
