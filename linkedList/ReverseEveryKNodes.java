import javax.management.NotificationEmitter;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class ReverseEveryKNodes {
    public static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node cur = head;
        for(int i = 0; i< n - 1; i++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        int k = scanner.nextInt();
        head = reverseEveryKNodes(head, k);
        cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static Node reverseEveryKNodes(Node head, int k) {
        if(head == null ||  k < 2) {
            return head;
        }
        Node tail = head;
        for(int i = 0; i < k; i++) {
            if(tail == null) {
                return head;
            }
            tail = tail.next;
        }
        Node newHead = reverse(head, tail);
        head.next = reverseEveryKNodes(tail, k );
        return newHead;
    }

    private static Node reverse(Node head, Node tail) {
        Node pre = null;
        Node next = null;
        while(head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
