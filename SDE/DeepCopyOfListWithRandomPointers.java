public class DeepCopyOfListWithRandomPointers {
    
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class DCOLWR {
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        Node curr = head;
        while(curr != null){
            Node copy  = new Node(curr.val);
            copy.next  = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null){
            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node copyHead = head.next;
        curr = head;
        Node nextNode = null;
        while (curr != null){
            nextNode = curr.next.next;
            if (nextNode != null){
                curr.next.next = nextNode.next;
            }
            curr.next = nextNode;
            curr = curr.next;
        }
        return copyHead;
     }

}