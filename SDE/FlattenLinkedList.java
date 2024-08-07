public class FlattenLinkedList {
    public static void main(String[] args) {
        Node root  = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        root.next.bottom = new Node(20);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
        root.next.next.next.bottom = new Node(35);
        root.next.next.next.bottom.bottom = new Node(40);
        root.next.next.next.bottom.bottom.bottom = new Node(45);
        GfG gfg = new GfG();
        Node ans = gfg.flatten(root);
        while(ans != null){
            System.out.printf("%d ", ans.data);
            ans = ans.next ;
        }
    }
}

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

class GfG {
    Node flatten(Node root) {
        Node curr  = root;
        while (curr.next != null){

            if (curr.bottom == null){
                curr = curr.next;
                continue;
            }
            if (curr.next.data >= curr.bottom.data ){
                Node btm = curr.bottom;
                curr.bottom = null;                                
                btm.next = curr.next;
                curr.next  = btm;
                curr= btm;
            }
            else{
                Node ind = curr;
                Node prv = null;
                while(ind.next != null && ind.data < curr.bottom.data){
                    prv = ind ;
                    ind = ind.next;
                }
                if (ind.next == null && ind.data < curr.bottom.data){
                    ind.next = curr.bottom;
                    curr.bottom = null;
                    curr = curr.next;
                }
                else{
                    prv.next = curr.bottom;
                    curr.bottom.next = ind;
                    curr.bottom = null;
                    curr= curr.next;
                }
            }
        }
        while (curr != null){
            Node btm = curr.bottom;
            curr.next = btm;
            curr.bottom = null;
            curr  = btm;
        }
        return root;
    }
}