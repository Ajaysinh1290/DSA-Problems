import java.util.HashSet;

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode firstF = new ListNode(1);
        ListNode secondF = new ListNode(2);
        firstF.next = secondF;
        ListNode thirdF = new ListNode(3);
        secondF.next = thirdF;
        ListNode forthF = new ListNode(4);
        thirdF.next = forthF;
        forthF.next = secondF;
        ListNode result = detectCycle(firstF);
        System.out.println("Result is "+result.val);
        
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