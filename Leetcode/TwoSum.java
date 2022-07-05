import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] dp = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target-num)) {
                dp[0] = map.get(target-num);
                dp[1] = num;
                return dp;
            }
            map.put(num, i);
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int[] result = twoSum(nums,100);
        System.out.println(Arrays.toString(result));
    }
}
