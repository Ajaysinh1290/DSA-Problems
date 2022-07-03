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

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        if (n == 1) {
            for (int i = 0; i < m; i++) {
                System.out.println(i);
                matrix[i][0] = -1;
                if (head != null) {
                    matrix[i][0] = head.val;
                    head = head.next;
                }

            }
            return matrix;
        }else if(m==1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = -1;
                if (head != null) {
                    matrix[0][i] = head.val;
                    head = head.next;
                }

            }
            return matrix;
        }

        int minX = 0;
        int minY = 0;

        while (minX < m && minY < n) {

            for (int j = minY; j < n && minX < m && minY < n; j++) {
                matrix[minX][j] = -1;
                if (head != null) {
                    matrix[minX][j] = head.val;
                    head = head.next;
                }
            }
            n = n - 1;
            minX++;
            for (int i = minX; i < m && minX <= m && minY <=n; i++) {
                matrix[i][n] = -1;
                if (head != null) {
                    matrix[i][n] = head.val;
                    head = head.next;
                }
            }
            m = m - 1;
            for (int j = n - 1; j >= minY && minX <= m && minY <=n; j--) {
                matrix[m][j] = -1;
                if (head != null) {
                    matrix[m][j] = head.val;
                    head = head.next;
                }
            }

            for (int i = m - 1; i >= minX && minX <= m && minY <=n; i--) {
                matrix[i][minY] = -1;
                if (head != null) {
                    matrix[i][minY] = head.val;
                    head = head.next;
                }
            }
            minY++;

        }
        return matrix;

    }

    public static void fillMatrix(int[][] matrix, int i, int j, int m, int n, ListNode head) {
        System.out.println("i : " + i + " j : " + j);
        if (i < 0 || j < 0) {
            return;
        }

        if (i < m && j < n) {
            if (head == null) {
                matrix[i][j] = -1;
            } else {
                matrix[i][j] = head.val;
                head = head.next;
            }
        }

        if ((j + 1) < n && (i + 1) != m) {
            fillMatrix(matrix, i, j + 1, m, n, head);
        } else if ((i + 1) == m && j >= 0) {
            if (j == 0) {

                fillMatrix(matrix, i - 1, j, m, n, head);
            } else {
                fillMatrix(matrix, i >= m ? (m - 1) : i, j - 1, m, n, head);
            }
        } else if ((j + 1) == n) {
            if ((i + 1) < m) {
                fillMatrix(matrix, i + 1, j >= n ? (n - 1) : j, m, n, head);
            } else if ((i + 1) == m) {
                fillMatrix(matrix, i >= m ? (m - 1) : i, j - 1, m, n, head);
            }
        } else if (i == 0) {
            fillMatrix(matrix, i, j + 1, j == 0 ? (m - 1) : m, j == 0 ? n - 1 : n, head);
        }

    }

    public static void main(String[] args) {
        int[] nums = {47,708,1,918,227,334,115,863,636,769,117,557,940,54,83};
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
