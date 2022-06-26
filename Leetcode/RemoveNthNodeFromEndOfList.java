import java.util.List;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {
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

    //Solution 1 
    // public static ListNode removeNthFromEnd(ListNode head, int n) {
    //     int length = getLengthOfList(head);
    //     if(n==length) {
    //         return head.next;
    //     }
    //     n = length - n ;
    //     int counter = 0;
    //     ListNode cNode = head;
    //     while (cNode.next != null) {
    //         if ((counter+1 ) == n) {
    //             System.out.println("removing "+cNode.next.val);
    //             cNode.next = cNode.next.next;
    //             break;
    //         }
    //         counter++;
    //         cNode = cNode.next;
    //     }
    //     return head;
    // }

    // public static int getLengthOfList(ListNode node) {
    //     int length = 0;

    //     while (node != null && node.next != null) {
    //         node = node.next.next;
    //         length += 2;
    //     }
    //     if (node != null) {
    //         length = length + 1;
    //     }

    //     return length;
    // }

    public static ListNode removeNthFromEnd(ListNode head, int n) { 
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;

        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast!=null) {
            fast =fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {

        ListNode firstF = new ListNode(1);
        ListNode secondF = new ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new ListNode(3);
        secondF.next = thirdF;
        ListNode forthF = new ListNode(4);
        thirdF.next = forthF;

        ListNode result = removeNthFromEnd(firstF, 4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
