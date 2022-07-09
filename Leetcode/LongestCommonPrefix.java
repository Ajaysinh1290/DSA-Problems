public class LongestCommonPrefix {

    // static class Node {
    //     Node next;
    //     char ch;

    //     Node(char ch) {
    //         this.ch = ch;
    //     }

    //     char getCharacter() {
    //         return ch;
    //     }

    //     Node getNextNode() {
    //         return next;
    //     }
    // }

    // public static String longestCommonPrefix(String[] strs) {

    //     Node root = null;
    //     Node node = null;
    //     for (char ch : strs[0].toCharArray()) {

    //         if (root == null) {
    //             node = new Node(ch);
    //             root = node;
    //         } else {
    //             node.next = new Node(ch);
    //             node = node.next;
    //         }
    //     }
    //     for (int i = 1; i < strs.length; i++) {
    //         node = root;
    //         for (char ch : strs[i].toCharArray()) {
    //             if (node == null) {
    //                 break;
    //             }
    //             System.out.println("Node ch is "+ch+" ch is "+ch);
    //             if (node.ch == ch) {
    //                 System.out.println("Matching");
    //                 node = node.next;
    //             } 
    //             System.out.println(getString(root));
    //         }
    //         if (node != null) {
    //             node.next = null;
    //         }
    //     }
    //     String st = "";
    //     node = root;
    //     while (node != null) {
    //         st += node.ch;
    //         node = node.next;
    //     }
    //     return st;
    // }

    // public static String getString(Node node) {
    //     String str = "";
    //     while (node != null) {
    //         str += node.ch;
    //         node = node.next;
    //     }
    //     return str;
    // }

    public static  String longestCommonPrefix(String[] strs) {

        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = longestCommonPrefix(str, strs[i]);
        }
        return str;

    }

    public static String longestCommonPrefix(String str1, String str2) {

      
        int min = Math.min(str1.length(),str2.length());
        System.out.println("Str1 "+str1+" Str2 "+str2+" Min is "+min);
        for(int i = 0; i<min; i++) {
            if(str1.charAt(i)!=str2.charAt(i)) {
                return str1.substring(0,i);
            }
        }
        return str1.substring(0, min);
    }
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String str = longestCommonPrefix(strs);
        System.out.println("String is " + str);
    }
}
