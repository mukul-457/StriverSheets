public class RotateLinkedList {
    
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RLL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int n = 0;
        ListNode curr = head;
        ListNode tail = null;
        while (curr != null){
            n += 1;
            tail = curr;
            curr = curr.next;
        }
        int to_be_head_node = (n - (k % n ))%n;

        int node_num = 0;
        curr = head;
        ListNode prv = null;
        while (node_num < to_be_head_node){
            prv = curr;
            curr = curr.next;
            node_num += 1;
        }
        if (prv == null){
            return head;
        }
        prv.next = null;
        tail.next = head;
        return curr;
        


    }
}