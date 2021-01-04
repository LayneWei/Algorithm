import java.util.HashSet;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class RemoveRepeatNode {
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
        head = removeRepeatNode(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static Node removeRepeatNode(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        Node pre = null;
        while(cur != null) {
            Node next = cur.next;
            if(set.contains(cur.val)) {
                pre.next = next;
                cur = next;
            } else {
                set.add(cur.val);
                pre = cur;
                cur = next;
            }
        }
        return head;
    }
}
