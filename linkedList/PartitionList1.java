import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class PartitionList1 {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node partitionList(Node head, int pivot) {
        int len = 0;
        Node cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        Node[] arr = new Node[len];
        cur = head;
        for(int i = 0; i< len; i++) {
            arr[i] = cur;
            cur = cur.next;
        }
        int small = -1;
        int large = arr.length;
        int index = 0;
        while (index < large) {
            if (arr[index].val < pivot) {
                swap(arr,index++,++small);
            } else if (arr[index].val == pivot) {
                index++;
            } else {
                swap(arr,index,--large);
            }
        }
        Node head1 = arr[0];
        Node cur1 = head1;
        for(int i = 1; i< len; i++) {
            cur1.next = arr[i];
            cur1 = cur1.next;
        }
        cur1.next = null;
        return head1;
    }

    private static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pivot = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node cur = head;
        for(int i = 0; i < n - 1; i++) {
            Node node = new Node(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        head = partitionList(head, pivot);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
