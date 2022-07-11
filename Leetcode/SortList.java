
public class SortList {

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

    public static ListNode getMiddleElement(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        ListNode prev = slow;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast.next != null) {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        System.out.println("Divided Array");
        printList(head);
        printList(slow);
        System.out.println("--------");
        return slow;
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        System.out.println("Getting middle ele");
        ListNode middle = getMiddleElement(head);
        ListNode fp = sortList(head);
        ListNode sp = sortList(middle);
        return merge(fp, sp);
    }

    public static ListNode merge(ListNode l, ListNode h) {
        if (l == null || h == null) {
            return l == null ? h : l;
        }
        System.out.println("Merging l "+l.val+" and h "+h.val);
        ListNode node = new ListNode(0);
        ListNode root = node;
        while (l != null && h != null) {
            System.out.println("Comparing value of l "+l.val+" h "+h.val);
            if (l.val < h.val) {
                node.next = l;
                l = l.next;
            } else {
                node.next = h;
                h = h.next;
            }
            node = node.next;
        }
        if(l!=null) {
            node.next = l;
            node = node.next;
        }
        if(h!=null) {
            node.next = h;
            node = node.next;
        }
    
        System.out.println("Merged Array");
        printList(root.next);
        return root.next;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 5, 6, 4, 7 ,-2};

        ListNode root = createLinkedListFromArray(nums);
        ListNode result = sortList(root);

        printList(result);
    }
}
