/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeList {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listGenerator(int length, String[] numbers) {
        Node head = new Node(Integer.parseInt(numbers[0]));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value +" ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head = new Node(-1);
        Node cur = head;
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head1 != null ? head1 : head2;
        return head.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        String[] number1 = bufferedReader.readLine().split(" ");
        int num2 = Integer.parseInt(bufferedReader.readLine());
        String[] number2 = bufferedReader.readLine().split(" ");
        Node head1 = listGenerator(num1, number1);
        Node head2 = listGenerator(num2, number2);
        Node head = merge(head1, head2);
        printList(head);
    }
}