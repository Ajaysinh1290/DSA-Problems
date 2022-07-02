// https://leetcode.com/problems/find-pivot-index/

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
     
        int leftSum = 0;
        int total = getSum(nums);
        
        for (int i = 0; i < nums.length; i++) {
            leftSum +=(i==0?0:nums[i-1]);
            if (leftSum == total-leftSum-nums[i])
                return i;
        }
        return -1;
    }

    public static int getSum(int nums[]) {
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,2,1};
        int result  = pivotIndex(nums);
        System.out.println("Result is "+result);
    }
}
