import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int array[] = new int[nums1.length+nums2.length];
        int index = 0;
        for (int i : nums1) {
            array[index] = i;
            index++;
        }
        for (int i : nums2) {
            array[index] = i;
            index++;
        }
        Arrays.sort(array);
        System.out.println("Array is "+Arrays.toString(array));
        int mIndex = array.length/2;
        System.out.println("Middle Index is "+mIndex);
        if(array.length%2==0) {
            System.out.println(" number1 is "+array[mIndex-1]+" number2 is "+array[mIndex]);
            result =  (Double.parseDouble(array[mIndex-1]+"")+Double.parseDouble(array[mIndex]+""))/2.00000;
        } else {
            
            result = array[mIndex];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array1 = {1,3,1,8};
        int[] array2 = {2,3,4,1};

        double result = findMedianSortedArrays(array1, array2);
        System.out.println("Result is "+result);
    }
}
