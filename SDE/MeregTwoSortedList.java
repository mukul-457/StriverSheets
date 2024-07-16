public class MeregTwoSortedList {
    
}


//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

class MTSL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }

        ListNode sorted_node ;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode head;
        if (curr1.val  <= curr2.val){
            sorted_node = curr1;
            head = curr1;
            curr1 = curr1.next;
        }else{
            sorted_node  = curr2;
            head = curr2;
            curr2 = curr2.next;
        }

        while (curr1 != null  &&  curr2 != null){
            if (curr1.val <= curr2.val ){
                sorted_node.next = curr1;
                curr1 = curr1.next;   
            }else{
                sorted_node.next = curr2;
                curr2 = curr2.next;
            }
            sorted_node = sorted_node.next;
        }
        if (curr2 != null){
            sorted_node.next = curr2;
        }else if (curr1 != null){
            sorted_node.next = curr1;
        }

        return head;

    }
}