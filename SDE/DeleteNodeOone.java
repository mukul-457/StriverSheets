public class DeleteNodeOone {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode curr = head;
        curr.next  = new ListNode(5);
        curr = curr.next;
        curr.next = new ListNode(1);
        curr= curr.next;
        curr.next = new ListNode(9);

        curr = head.next;
        DNO dno = new DNO();
        dno.deleteNode(curr);
        
        curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

class DNO {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode curr = node;
        ListNode prv = null;
        while (next != null){
            curr.val = next.val;
            next = next.next;
            prv= curr;
            curr = curr.next;
        }
        prv.next  = null;
    }
}