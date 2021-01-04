import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class CombineLeftRight {
    private static StreamTokenizer in =
            new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static ListNode relocate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = head;
        ListNode right = head.next;
        while(right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        merge(head, right);
        return head;
    }

    public static void merge(ListNode head, ListNode right) {
        ListNode next = null;
        ListNode pre = head;
        while(pre.next != null) {
            next = right.next;
            right.next = pre.next;
            pre.next = right;
            pre = right.next;
            right = next;
        }
        pre.next = right;
    }


    private static ListNode read() {
        int size = nextInt();
        ListNode head = new ListNode(0);
        ListNode last = head;
        for (int i = 0; i < size; i++) {
            ListNode next = new ListNode(nextInt());
            last.next = next;
            last = next;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static int nextInt() {
        try {
            in.nextToken();
            return (int) in.nval;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] args) {
        ListNode head1 = read();
        ListNode head = relocate(head1);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}