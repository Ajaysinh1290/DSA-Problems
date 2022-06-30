// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree {

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

    // Recursive Approach 
    // public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null)
    //         return null;
    //     if (root.val == p.val||root.val==q.val) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if (left != null && right != null) {
    //         return root;
    //     }
    //     return left != null ? left : right;
    // }

    // Iterative Approach and Optimized solution

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        
        while(true) {
            if(root.val>p.val&&root.val>q.val) {
                root = root.left;
            }
            else if(root.val<p.val&&root.val<q.val) {
                root = root.right;
            }
            else  {
                return root;
            }
        }
       
        
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

        TreeNode result = lowestCommonAncestor(root, sNode, FNode);
        System.out.println("Result is " + result.val);
    }
}
