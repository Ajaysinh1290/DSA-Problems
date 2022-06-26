// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
    // Solution 1
    // public static ListNode middleNode(ListNode head) {
    //     int length = 0;

    //     ListNode iNode = head;
    //     while (head != null) {
    //         length++;
    //         head = head.next;
    //     }
    //     int middleIndex = length / 2;
    //     head = iNode;

    //     int counter = 0;
    //     while (counter < middleIndex) {
    //         head = head.next;
    //         counter++;
    //     }
    //     return head;
    // }

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


    // Solution 2
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

     
        ListNode firstF = new ListNode(1);
        ListNode secondF = new ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new ListNode(3);
        secondF.next = thirdF;
        ListNode forthF = new ListNode(4);
        thirdF.next = forthF;

        
        ListNode result = middleNode(firstF);
        System.out.println("MIddle element "+result.val);
        // while (result != null) {
        //     System.out.print(result.val + " ");
        //     result = result.next;
        // }
    }
}

