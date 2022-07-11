public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public static int binarySearch(int[] nums, int l, int h, int target) {

        if (h - l == 1) {
            return nums[l] >= target ? (l) : (l + 1);
        }
        int middle = l + (h - l) / 2;

        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return binarySearch(nums, l, middle, target);
        } else {
            return binarySearch(nums, middle, h, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,5,8,9};
        int result = searchInsert(nums, 2);
        System.out.println("Result is "+result);
    }
}
