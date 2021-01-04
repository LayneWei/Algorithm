import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class RemoveNode {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node removeNode(Node head, int m) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy;
        for(int i =0; i < m - 1 ; i++) {
            if(cur == null) {
                return dummy;
            }
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int m = scanner.nextInt();

        Node dummy = new Node(0);
        Node prev = dummy;
        for(int i = 0; i< n; i++) {
            Node node = new Node(scanner.nextInt());
            prev.next = node;
            prev = prev.next;
        }
        removeNode(dummy.next,m);
        Node cur = dummy.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
