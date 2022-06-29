// https://leetcode.com/problems/binary-search/

public class BinarySearch {

    // Recursive Approach
    // public static int search(int[] nums, int target) {
    //     return binarySearch(nums, target, 0, nums.length);
    // }

    // public static int binarySearch(int[] nums, int target, int low, int high) {
    //     if (low >= high)
    //         return -1;
    //     int mid = low + (high - low) / 2;
    //     if (nums[mid] == target)
    //         return mid;
    //     if (nums[mid] > target) {
    //         return binarySearch(nums, target, low, mid);
    //     } else {
    //         return binarySearch(nums, target, mid + 1, high);
    //     }
    // }


    // Iterative Approach
    public static int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return -1;
        int s = 0;
        int end = nums.length - 1;
        while (s <= end) {
            int mid = s + (end - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                s = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { -1, 0, 3, 5, 9, 12 };
        int result = search(array, 9);
        System.out.println(result);

    }
}
