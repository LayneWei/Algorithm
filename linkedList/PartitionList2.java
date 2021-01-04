import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class PartitionList2 {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pivot = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node cur = head;
        for(int i = 1 ; i < n; i ++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        head = partitionList(head,pivot);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static Node partitionList(Node head, int pivot) {
        Node small = new Node(0);
        Node smallCur = small;
        Node equal = new Node(0);
        Node equalCur = equal;
        Node big = new Node(0);
        Node bigCur = big;
        Node cur = head;
        while(cur != null) {
            if(cur.val < pivot) {
                smallCur.next = cur;
                smallCur = smallCur.next;
                cur = cur.next;
            }  else if(cur.val == pivot) {
                equalCur.next = cur;
                equalCur = equalCur.next;
                cur = cur.next;
            } else {
                bigCur.next = cur;
                bigCur = bigCur.next;
                cur = cur.next;
            }
        }
        if(equal.next != null) {
            smallCur.next = equal.next;
            equalCur.next = big.next;
        } else {
            smallCur.next = big.next;
        }
        bigCur.next = null;
        return small.next;
    }
}
