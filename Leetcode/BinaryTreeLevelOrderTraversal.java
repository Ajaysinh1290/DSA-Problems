// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    // Solution 1
    // public static List<List<Integer>> list = new ArrayList<>();

    // public static List<List<Integer>> levelOrder(TreeNode root) {

    // if(root==null) return list;
    // ArrayList<Integer> arrayList = new ArrayList<>();
    // arrayList.add(root.val);
    // list.add(arrayList);
    // createList(root,1);
    // return list;
    // }

    // public static void createList(TreeNode node,int index) {
    // if (node == null) {
    // return;
    // }
    // if(index>=list.size()) {
    // while(index>=list.size()) {
    // list.add(new ArrayList<>());
    // }
    // }
    // List<Integer> arrayList = list.get(index);
    // if (node.left != null) {
    // arrayList.add(node.left.val);
    // }
    // if (node.right != null) {
    // arrayList.add(node.right.val);
    // }
    // if(arrayList.isEmpty()) {
    // list.remove(index);
    // }
    // createList(node.left,index+1);
    // createList(node.right,index+1);

    // }

    // Solution 2
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

        List<List<Integer>> result = levelOrder(root);

        for (List<Integer> i : result) {
            System.out.println(Arrays.deepToString(i.toArray()));
        }

    }
}
