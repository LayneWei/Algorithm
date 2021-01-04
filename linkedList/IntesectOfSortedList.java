import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class IntesectOfSortedList {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void findIntersect(Node n1, Node n2) {
        if(n1 == null || n2 == null) {
            return;
        }
        Node h1 = n1;
        Node h2 = n2;
        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                h1 = h1.next;
            } else if(h1.val > h2.val) {
                h2 = h2.next;
            } else {
                System.out.print(h1.val + " ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head1 = new Node(0);
        Node prev = head1;
        for(int i = 0; i< n; i ++) {
            prev.next = new Node(scanner.nextInt());
            prev = prev.next;
        }
        Node head2 = new Node(0);
        prev = head2;
        int m = scanner.nextInt();
        for(int j = 0; j < m; j++) {
            prev.next = new Node(scanner.nextInt());
            prev = prev.next;
        }
        findIntersect(head1.next,head2.next);
    }
}
