import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    // public static List<Integer> rightSideView(TreeNode root) {
    // List<Integer> list = new ArrayList<Integer>();
    // if (root == null) {
    // return list;
    // }
    // addElement(root, list, 0, 0);
    // return list;
    // }

    // public static int addElement(TreeNode node, List<Integer> list, int max, int
    // index) {

    // if (node == null) {
    // // if node is null then we will return it's index because there is
    // possibility
    // // that this node has max height
    // return index;
    // }
    // if (index >= max) {
    // // if index has more height then max then we will add that value in list
    // list.add(node.val);
    // }

    // // we will get max height from right
    // int maxToRight = addElement(node.right, list, max, index + 1);
    // // we will pass max between right side height and height we got from parent
    // function
    // int maxToLeft = addElement(node.left, list, Math.max(max, maxToRight), index
    // + 1);
    // // we will return max height between left and right
    // return Math.max(maxToRight, maxToLeft);
    // }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode fNode = new TreeNode(3);
        TreeNode sNode = new TreeNode(6);
        TreeNode TNode = new TreeNode(1);
        TreeNode FNode = new TreeNode(5);
        TreeNode SNode = new TreeNode(2);
        root.left = fNode;
        root.right = sNode;

        fNode.left = TNode;
        TNode.right = SNode;
        sNode.left = FNode;
        // int[] nums = { 1, 2, 3, -1, 5, -1, 4 };
        // TreeNode root = createBinaryTreeFromArray(nums, 0);
        // List list = levelOrder(root);
        // System.out.println(Arrays.toString(list.toArray()));
        List<Integer> result = rightSideView(root);
        System.out.println(Arrays.toString(result.toArray()));

    }
}
