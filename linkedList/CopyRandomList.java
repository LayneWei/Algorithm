import org.w3c.dom.Node;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
class CopyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while(cur != null) {
            Node next = cur.next.next;
            Node curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node newHead = head.next;
        cur = head;
        while(cur != null) {
            Node next = cur.next.next;
            Node curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur.next = next;
            cur = next;
        }
        return newHead;

    }
}