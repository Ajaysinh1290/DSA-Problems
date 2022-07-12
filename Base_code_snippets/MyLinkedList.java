public class MyLinkedList {
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

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createLinkedListFromArray(int[] nums) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 5, 6, 4, 7 };

        ListNode root = createLinkedListFromArray(nums);
        printList(root);
    }
}
