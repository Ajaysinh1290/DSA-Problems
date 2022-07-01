// https://leetcode.com/problems/flood-fill/

import java.util.Arrays;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void floodFill(int[][] image, int sr, int sc, int color, int inValue) {

        image[sr][sc] = color;
        if ((sr - 1) != -1 && image[sr - 1][sc] == inValue && image[sr - 1][sc] != color) {
            floodFill(image, sr - 1, sc, color, inValue);
        }
        if ((sr + 1) < image.length && image[sr + 1][sc] == inValue && image[sr + 1][sc] != color) {
            floodFill(image, sr + 1, sc, color, inValue);
        }
        if ((sc - 1) != -1 && image[sr][sc - 1] == inValue && image[sr][sc - 1] != color) {
            floodFill(image, sr, sc - 1, color, inValue);
        }
        if ((sc + 1) < image[sr].length && image[sr][sc + 1] == inValue && image[sr][sc + 1] != color) {
            floodFill(image, sr, sc + 1, color, inValue);
        }
    }

    public static void main(String[] args) {

        int[][] image = {
                { 0, 0, 0 },
                { 0, 0, 0 },
        };
        int[][] result = floodFill(image, 1, 0, 2);
        for (int[] nums : result) {
            System.out.println(Arrays.toString(nums));
        }
    }
}
