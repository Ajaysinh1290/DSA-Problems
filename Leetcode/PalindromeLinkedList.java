import java.util.Stack;

public class PalindromeLinkedList {

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

    // public static boolean isPalindrome(ListNode head) {
    // ListNode node = head;
    // Stack<Integer> stack = new Stack();
    // while (node != null) {
    // stack.push(node.val);
    // node = node.next;
    // }
    // node = head;
    // int n = stack.size();
    // for (int i = 0; i <= n / 2; i++) {
    // if (stack.pop() == node.val) {
    // node = node.next;
    // } else {
    // return false;
    // }
    // }
    // return true;
    // }
    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        printList(slow);
        slow = reverseList(slow);
        printList(slow);
        while(slow!=null) {
            if(slow.val==head.val) {
                slow = slow.next;
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while(head!=null) {
                    ListNode next = head.next;
                    head.next = prev;
                    prev = head;
                    head = next;
            }
            return prev;
        }
    public static void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode firstF = new ListNode(1);
        ListNode secondF = new ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new ListNode(1);
        secondF.next = thirdF;
        ListNode forthF = new ListNode(1);
        thirdF.next = forthF;
        boolean result = isPalindrome(firstF);
        System.out.println("Result is " + result);

    }
}
