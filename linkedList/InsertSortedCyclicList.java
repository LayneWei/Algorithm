import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class InsertSortedCyclicList {
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
        for(int i = 0; i < n - 1; i++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        int num = scanner.nextInt();
        head = insert(head,num);
        cur = head;
        while(cur.next != head) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.print(cur.val);
    }

    private static Node insert(Node head, int num) {
        Node node = new Node(num);
        if(head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while(cur != head) {
            if(pre.val <= num && cur.val >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.val < num ? head : node;
    }
}
