/*
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
 */

public class MergeTwoSortedLists {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
         if(list2==null){
             return list1;
         }
         if(list1.val<list2.val){
             list1.next = mergeTwoLists(list1.next , list2);
             return list1;
         }
         else{
             list2.next = mergeTwoLists(list2.next , list1);
         }
          return list2;
    }

    public static void main(String[] args) {
        ListNode firstF = new  ListNode(1);
        ListNode secondF = new  ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new  ListNode(3);
        secondF.next = thirdF;

        ListNode firstS = new  ListNode(1);
        ListNode secondS = new  ListNode(3);
        firstS.next = secondS;
        ListNode thirdS = new  ListNode(4);
        secondS.next = thirdS;

        ListNode result =  mergeTwoLists(firstF,firstS);
        System.out.println("Merged sorted list");
        while(result!=null) {
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}

