
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // Solution 1 with global variable
    // static long minNumber = Long.MIN_VALUE;

    // public static boolean isValidBST(TreeNode root) {
    //     if (root.left != null && !isValidBST(root.left)) {
    //         return false;
    //     }
    //     if (minNumber >= root.val) {
    //         return false;
    //     }
    //     minNumber = root.val;
    //     if (root.right != null && !isValidBST(root.right)) {
    //         return false;
    //     }
    //     return true;
    // }

    // Solution 2 : Without global variable


    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right,
                root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode fNode = new TreeNode(4);
        TreeNode sNode = new TreeNode(6);
        TreeNode TNode = new TreeNode(3);
        TreeNode FNode = new TreeNode(7);
        root.left = fNode;
        root.right = sNode;
        sNode.left = TNode;
        sNode.right = FNode;
        boolean result = isValidBST(root);
        System.out.println("Result is " + result);
    }
}
