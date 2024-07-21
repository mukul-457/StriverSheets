import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroups {
    
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class RNKG {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode kStart = head;
       ListNode prvTail = null;
       ListNode newHead  = null;
       while (kStart != null){
        List<ListNode> data  = reverse(kStart, k);
        if (data.get(1) == null){
            if (newHead == null){
                newHead = head;
            }else{
                prvTail.next = kStart;
            }
            break;
        }else if (prvTail != null){
            prvTail.next = data.get(1);
            prvTail = data.get(0);
            kStart = data.get(2);
        }else{
            newHead = data.get(1);
            prvTail = data.get(0);
            kStart = data.get(2);
        }

       }

       return newHead;

    }

    public List<ListNode> reverse(ListNode head, int k ){
        List<ListNode> data = new ArrayList<>();
        ListNode prv = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0 ;
        while (count < k && curr !=  null){
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
            count++;
        }
        if (count < k){
            reverse(prv, count);
            data.add(head);
            data.add(null);
            data.add(null);
            return data;
        }
        data.add(head);
        data.add(prv);
        data.add(curr);

        return data;

    }
}