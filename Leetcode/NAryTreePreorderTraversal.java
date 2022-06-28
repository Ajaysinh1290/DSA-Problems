// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
   static  class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // public static List<Integer> preorder(Node root) {
    //     List<Integer> list = new ArrayList();

    //     list.add(root.val);

    //     if(root.children==null) return list;
    //     for(Node i : root.children) {
    //         List<Integer> newList = preorder(i);
    //         list.addAll(newList);
    //     }
        
    //     return list;
    // }

    // Solution 2 
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
    
    public static void main(String[] args) {
        int[] list = {1,3,2,4,5,6};

        Node root = new Node(list[0]);
        Node fc = new Node(list[1]);
        Node sc = new Node(list[2]);
        Node tc = new Node(list[3]);
        root.children = new ArrayList<>();
        root.children.add(fc);
        root.children.add(sc);
        root.children.add(tc);

        Node ffc = new Node(list[4]);
        Node fsc = new Node(list[5]);
        fc.children = new ArrayList<>();
        fc.children.add(ffc);
        fc.children.add(fsc);

        List<Integer> result = preorder(root);
        
        for(int i : result) {
            System.out.println(i);
        }

    }
}
