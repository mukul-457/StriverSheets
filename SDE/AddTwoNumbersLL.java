public class AddTwoNumbersLL {
    
}


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ATNLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode result =  new ListNode(( l1.val  + l2.val  ) % 10) ;
        int carry  = ( l1.val + l2.val ) / 10 ; 
        l1 = l1.next;
        l2 = l2.next;
        ListNode curr = result;
        while ( l1 != null & l2 != null){
            int total = l1.val + l2.val + carry;
            curr.next  = new ListNode(total % 10);
            carry = total / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null){
            curr.next = addTwoNumbers(new ListNode(carry), l2);
            carry = 0;
        }else if (l2 == null){
            curr.next = addTwoNumbers(l1, new ListNode(carry));
            carry = 0 ;
        }
        if (carry != 0){
            curr.next = new ListNode(carry);
        }

        return result;
    }
}