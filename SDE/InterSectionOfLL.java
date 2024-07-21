import java.util.List;

public class InterSectionOfLL {
    public static void main(String[] args) {
        
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ISOLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode modifiedStart = reverseAndConnect(headA, headB);
        ListNode intersection = findInterSection(modifiedStart);
        if (intersection == null){
            return null;
        }
        retainShape(modifiedStart, headA);
        return intersection;
    }

    public void retainShape(ListNode start, ListNode end){
        ListNode curr = start;
        ListNode next = null;
        ListNode prv = null;
        while (curr != end){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr= next ;
        }
        curr.next = prv;                
    }

    public ListNode findInterSection(ListNode entry){
        ListNode slow = entry;
        ListNode fast = entry;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }

        slow = entry;
        while (slow != fast){
            slow  = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode reverseAndConnect(ListNode toReverse , ListNode toConnect){
        ListNode curr = toReverse.next;
        while(toReverse != null){
            toReverse.next = toConnect;
            toConnect  = toReverse;
            toReverse = curr;
            curr = curr.next;
        }
        return toConnect;
    }



}