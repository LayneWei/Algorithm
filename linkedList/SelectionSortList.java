import com.sun.tools.attach.AgentInitializationException;

import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class SelectionSortList {
    public static class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static class NodeWrapper{
        Node min;
        Node rest;
        public NodeWrapper(Node min, Node rest) {
            this.min = min;
            this.rest = rest;
        }
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
        head = selectionSort(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static Node selectionSort(Node head) {
        NodeWrapper res = getMinNode(head);
        Node newHead = res.min;
        Node rest = res.rest;
        Node cur = newHead;
        while(rest != null) {
            NodeWrapper temp = getMinNode(rest);
            cur.next = temp.min;
            cur = cur.next;
            rest = temp.rest;
        }
        return newHead;
    }

    private static NodeWrapper getMinNode(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new NodeWrapper(head,null);
        }
        Node minNode = head;
        Node cur  = head;
        Node pre = null;
        Node minPre = null;
        while(cur != null) {
            if(cur.val < minNode.val) {
                minNode = cur;
                minPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        if(minPre == null) {
            Node rest = minNode.next;
            minNode.next = null;
            return new NodeWrapper(minNode,rest);
        } else {
            minPre.next = minNode.next;
            minNode.next = null;
            return new NodeWrapper(minNode,head);
        }
    }
}
