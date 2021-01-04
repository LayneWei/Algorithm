import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class AddList {
    public static class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node cur = head;
        Node node = cur;
        for(int i = 1; i < n; i++) {
            node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        Node head2 = new Node(scanner.nextInt());
        cur = head2;
        node = null;
        for(int i = 1; i < m; i++) {
            node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        head = addList(head, head2);
        cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static Node addList(Node head, Node head2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Node cur = head;
        while(cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = head2;
        while(cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        int addOne = 0;
        Node pre = null;
        cur = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int valSum = val1 + val2 + addOne;
            cur = new Node(valSum % 10);
            addOne = valSum / 10;
            cur.next = pre;
            pre = cur;
        }
        if (addOne == 1) {
            Node res = new Node(1);
            res.next = pre;
            return res;
        } else {
            return pre;
        }
    }
}
