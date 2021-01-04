import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class ReversePartList {
    public static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node reversePartList(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node firstTail = null;
        Node thirdHead = null;
        while(node1 != null) {
            len++;
            firstTail = len == from - 1? node1 : firstTail;
            thirdHead = len == to + 1? node1 : thirdHead;
            node1 = node1.next;
        }
        if(from < 1 || to > len || from >= to) {
            return head;
        }
        node1 = firstTail == null ? head : firstTail.next;
        Node node2 = node1.next;
        Node next = null;
        node1.next = thirdHead;
        while(node2 != thirdHead) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(firstTail != null) {
            firstTail.next = node1;
            return head;
        }
        return node1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node pre = head;
        for(int i = 0; i < n - 1; i++) {
            Node node = new Node(scanner.nextInt());
            pre.next = node;
            pre = pre.next;
        }
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        Node node = reversePartList(head,from,to);
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
