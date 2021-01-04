import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class JosephusKill {

    public static class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node josephusKill(Node head, int m){
        int len = 1;
        Node cur = head.next;
        while(cur != head) {
            len++;
            cur = cur.next;
        }
        int n = getLastLive(len,m);
        for(int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;
    }

    private static int getLastLive(int len, int m) {
        int ans = 0;
        for(int i = 2; i <= len; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Node head = new Node(1);
        Node cur = head;
        for(int i = 2; i < n + 1; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        System.out.println(josephusKill(head,m).val);
    }
}
