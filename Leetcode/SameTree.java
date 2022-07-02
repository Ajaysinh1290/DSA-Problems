// https://leetcode.com/problems/same-tree/

public class SameTree {

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


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val != q.val)  return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode fNode = new TreeNode(9);
        TreeNode sNode = new TreeNode(20);
        TreeNode TNode = new TreeNode(15);
        TreeNode FNode = new TreeNode(7);
        root.left = fNode;
        root.right = sNode;
        sNode.left = TNode;
        sNode.right = FNode;
        boolean result = isSameTree(root, fNode);
        System.out.println("Result is "+result);
    }
}
