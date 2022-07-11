
public class OddEvenLinkedList {
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

    public static ListNode oddEvenList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenRoot = even;

        while (even != null && even.next!=null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenRoot;
        return head;
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
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createLinkedListFromArray(int[] nums) {
        ListNode node = new ListNode();
        ListNode root = node;
        for (int i = 0; i < nums.length; i++) {
            node.val = nums[i];
            if (root == null) {
                root = node;
            }
            if (i + 1 < nums.length) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = { 2,1,3,5,6,4,7};

        ListNode root = createLinkedListFromArray(nums);
        ListNode result = oddEvenList(root);
        printList(result);
    }
}
