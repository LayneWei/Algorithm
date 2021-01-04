import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class IsPalindromList {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }
    public static boolean isPalindromeList(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        while(slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        Node cur = head;
        while(!stack.isEmpty()) {
            if(stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;

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
        System.out.println(isPalindromeList(head));
    }
}
