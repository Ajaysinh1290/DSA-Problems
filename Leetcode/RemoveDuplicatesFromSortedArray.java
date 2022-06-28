// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {

    // Solution 1
    // public static int removeDuplicates(int[] nums) {
    //     HashSet<Integer> hashSet = new HashSet<>();
    //     int length = 0;
    //     int index  = 0;
    //     for(int num: nums) {
    //         if(!hashSet.contains(num)) {
    //             hashSet.add(num);
    //             nums[index] = num;
    //             length++;
    //         }
    //     }   
    //     return length;
    // }
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int num : nums) { 
            if(index==0||num>nums[index-1]) {
                nums[index++] = num;
            }
        }   
        return index;
    }
 public static void main(String[] args) {
    int[] array = {1,1,23,33,33,36};
    int n = removeDuplicates(array);
    for(int i=0; i<n; i++) {
        System.out.println(array[i]);
    }
 }   
}
