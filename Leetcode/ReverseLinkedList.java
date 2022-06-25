// https://leetcode.com/problems/reverse-linked-list/


public class ReverseLinkedList {
    // Solution 1
    // public static ListNode reverseList(ListNode head) {
    //     if(head.next==null) {
    //         return head;
    //     }
    //     ListNode node = reverseList(head.next);
    //     ListNode iNode = node;
    //     while(node.next!=null) {
    //         node = node.next;
    //     }
    //     node.next = head;
    //     head.next = null;
    //     return iNode;
    // }


    // Solution 2 Optimized solution
    public static ListNode reverseList(ListNode head) {
       
        ListNode newHead = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode firstF = new  ListNode(1);
        ListNode secondF = new  ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new  ListNode(3);
        secondF.next = thirdF;
        ListNode result =  reverseList(firstF);
        System.out.println("Merged sorted list");
        while(result!=null) {
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
class ListNode {
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