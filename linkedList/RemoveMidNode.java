import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class RemoveMidNode {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node removeNode(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        while(fast.next != null && fast.next.next != null && fast.next.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node prev = slow;
        Node next = slow.next.next;
        prev.next = next;
        return dummy;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        Node dummy = new Node(0);
        Node prev = dummy;
        for(int i = 0; i< n; i++) {
            Node node = new Node(scanner.nextInt());
            prev.next = node;
            prev = prev.next;
        }
        removeNode(dummy.next);
        Node cur = dummy.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
