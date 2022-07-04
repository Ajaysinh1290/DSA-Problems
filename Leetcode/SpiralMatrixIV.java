import java.util.Arrays;

public class SpiralMatrixIV {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // public static int[][] spiralMatrix(int m, int n, ListNode head) {
    // int[][] matrix = new int[m][n];

    // if (n == 1) {
    // for (int i = 0; i < m; i++) {
    // System.out.println(i);
    // matrix[i][0] = -1;
    // if (head != null) {
    // matrix[i][0] = head.val;
    // head = head.next;
    // }

    // }
    // return matrix;
    // }else if(m==1) {
    // for (int i = 0; i < n; i++) {
    // matrix[0][i] = -1;
    // if (head != null) {
    // matrix[0][i] = head.val;
    // head = head.next;
    // }

    // }
    // return matrix;
    // }

    // int minX = 0;
    // int minY = 0;

    // while (minX < m && minY < n) {

    // for (int i = minY; i < n && minX < m && minY < n; i++) {
    // matrix[minX][i] = -1;
    // if (head != null) {
    // matrix[minX][i] = head.val;
    // head = head.next;
    // }
    // }
    // n = n - 1;
    // minX++;
    // for (int i = minX; i < m && minX <= m && minY <=n; i++) {
    // matrix[i][n] = -1;
    // if (head != null) {
    // matrix[i][n] = head.val;
    // head = head.next;
    // }
    // }
    // m = m - 1;
    // for (int i = n - 1; i >= minY && minX <= m && minY <=n; i--) {
    // matrix[m][i] = -1;
    // if (head != null) {
    // matrix[m][i] = head.val;
    // head = head.next;
    // }
    // }

    // for (int i = m - 1; i >= minX && minX <= m && minY <=n; i--) {
    // matrix[i][minY] = -1;
    // if (head != null) {
    // matrix[i][minY] = head.val;
    // head = head.next;
    // }
    // }
    // minY++;

    // }
    // return matrix;

    // }

    // Solution 2 Optimized solution
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        int top = 0;
        int left = 0;
        int right = n-1;
        int down = m-1;
        int dir = 0;

        while (top<=down&&left<=right) {

            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = -1;
                    if (head != null) {
                        matrix[top][i] = head.val;
                        head = head.next;
                    }
                }
                top++;
            }
            else if(dir==1) {
                for (int i = top; i <=down; i++) {
                    matrix[i][right] = -1;
                    if (head != null) {
                        matrix[i][right] = head.val;
                        head = head.next;
                    }
                }
                right--;
            }
            else if(dir==2) {
                for (int i = right; i >=left; i--) {
                    matrix[down][i] = -1;
                    if (head != null) {
                        matrix[down][i] = head.val;
                        head = head.next;
                    }
                }
                down--;
            }
            else if(dir==3) {
                for (int i = down; i >=top; i--) {
                    matrix[i][left] = -1;
                    if (head != null) {
                        matrix[i][left] = head.val;
                        head = head.next;
                    }
                }
                left++;
            }


            dir= (dir+1)%4;

        }
        return matrix;

    }

    public static void main(String[] args) {
        int[] nums = { 47, 708, 1, 918, 227, 334, 115, 863, 636, 769, 117, 557, 940, 54, 83 };
        ListNode node = new ListNode();
        ListNode root = node;
        for (int i = 0; i < nums.length; i++) {
            node.val = nums[i];
            if (root == null) {
                root = node;
            }
            if (i + 1 < nums.length) {
                node.next = new ListNode();
                node = node.next;
            }
        }

        int[][] result = spiralMatrix(10, 5, root);
        for (int[] num : result) {
            System.out.println(Arrays.toString(num));
        }
    }
}
