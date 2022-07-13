import java.util.*;

public class BalancedBinaryTree {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return list;
        queue.add(root);
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        list.add(rootList);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<Integer>();
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    levelList.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    levelList.add(node.right.val);
                    queue.add(node.right);
                }
                size--;
            }
            if (!levelList.isEmpty())
                list.add(levelList);
        }
        return list;
    }

    public static boolean isBalanced(TreeNode root) {

        return checkBalanced(root, 0) != -1;

    }

    public static int checkBalanced(TreeNode root, int index) {
        if (root == null) {
            return index;
        }
        int left = checkBalanced(root.left, index + 1);
        if (left == -1) {
            return -1;
        }
        int right = checkBalanced(root.right, index + 1);

        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) : -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode fNode = new TreeNode(2);
        TreeNode sNode = new TreeNode(2);
        TreeNode TNode = new TreeNode(3);
        TreeNode FNode = new TreeNode(3);
        TreeNode SNode = new TreeNode(4);
        TreeNode SeNode = new TreeNode(4);
        root.left = fNode;
        root.right = sNode;
        fNode.left = TNode;
        sNode.right = FNode;
        TNode.left = SNode;
        FNode.right = SeNode;

        boolean result = isBalanced(root);
        System.out.println("Result is " + result);
    }
}
