import java.util.*;

public class InvertBinaryTree {
    
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
    public static TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right =  invertTree(root.left);
        root.left  = invertTree(temp);
        return root;
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
        TreeNode result = invertTree(root);



        List<List<Integer>> list = levelOrder(result);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}
