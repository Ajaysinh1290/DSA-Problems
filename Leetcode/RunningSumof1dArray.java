// https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;

public class RunningSumof1dArray {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int prevSum = 0;
        for (int i=0; i<nums.length; i++) {
            result[i] = nums[i]+prevSum;
            prevSum = result[i];
        }

        return result;
    }
    public static void main(String[] args) {

        int array[] ={1,2,3,4};
        int[] result = runningSum(array);
        System.out.println(Arrays.toString(result));

        
    }
}
