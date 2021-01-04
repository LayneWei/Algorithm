import java.util.HashSet;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class RemoveTargetNode {
    public static class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node cur = head;
        for(int i = 1; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        int target = scanner.nextInt();
        head = removeTargetNode(head, target);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static Node removeTargetNode(Node head, int target) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy.next;
        Node pre = dummy;
        Node next = null;
        while(cur != null) {
            next = cur.next;
            if(cur.val == target) {
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}

