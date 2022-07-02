public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end) {
            int min = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea,min * (end-start));
            if(height[start]<height[end]) {
                start++;
            }
           else {
               end--;
           }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3};
        int height = maxArea(nums);
        System.out.println("Height is " + height);
    }
}
