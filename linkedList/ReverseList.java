import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class ReverseList {
    public static class SingleNode {
        int val;
        SingleNode next;

        public SingleNode(int val) {
            this.val = val;
        }
    }

    public static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode pre;

        public DoubleNode(int val){
            this.val = val;
        }
    }

    public static SingleNode reverseSingleList(SingleNode head) {
        if(head == null) {
            return head;
        }
        SingleNode pre = null;
        SingleNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SingleNode head = new SingleNode(scanner.nextInt());
        SingleNode cur = head;
        for(int i = 0; i < n - 1; i++) {
            SingleNode node = new SingleNode(scanner.nextInt());
            cur.next = node;
            cur = cur.next;
        }
        head = reverseSingleList(head);
        System.out.println(" ");
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        int m = scanner.nextInt();
        DoubleNode head2 = new DoubleNode(scanner.nextInt());
        DoubleNode cur2 = head2;
        for(int i = 0; i < m- 1; i ++) {
            DoubleNode node2 = new DoubleNode(scanner.nextInt());
            cur2.next = node2;
            node2.pre = cur2;
            cur2 = cur2.next;
        }
        head2 = reverseDoubleList(head2);
        while(head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
    }
}
