import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class RemoveKthNode {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Node prev = new Node(0);
        Node head = prev;
        for(int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            prev.next = node;
            prev = prev.next;
        }
        Node  node = removeKthNode(head.next, k);
        while(node != null ) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static Node removeKthNode(Node head, int k) {
        if(head == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        // k == 1 -> fast - slow = 0
        // k == 2 -> fast - slow = 1
        // need to get backwards k+1th
        // fast need to move at least k + 1 step
        for(int i = 0; i < k + 1; i++) {
            if(fast == null) {
                return dummy.next;
            }
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node prev = slow;
        Node next = slow.next.next;
        prev.next = next;
        return dummy.next;
    }
}
