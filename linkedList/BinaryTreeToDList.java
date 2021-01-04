import java.util.HashMap;
import java.util.Scanner;

/**
 * @author laynewei/'
 * @e-mail lengning_wei@berkeley.edu
 */
public class BinaryTreeToDList {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer, Node> map = new HashMap<>();
        Node root = null;
        for(int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            Node parent = null;
            Node left = null;
            Node right = null;
            int parentVal = Integer.parseInt(arr[0]);
            int leftVal = Integer.parseInt(arr[1]);
            int rightVal = Integer.parseInt(arr[2]);
            if(!map.containsKey(parentVal)) {
                parent = new Node(parentVal);
                map.put(parentVal,parent);
            } else {
                parent = map.get(parentVal);
            }
            if (i == 0) {
                root = parent;
            }
            if(!map.containsKey(leftVal) && leftVal != 0) {
                left = new Node(leftVal);
                map.put(leftVal,left);
            } else {
                left = leftVal == 0 ? map.get(leftVal) : null;
            }
            if(!map.containsKey(rightVal) && rightVal != 0) {
                right = new Node(rightVal);
                map.put(rightVal,right);
            } else {
                right = rightVal == 0 ? map.get(rightVal) : null;
            }
            parent.left = left;
            parent.right = right;
        }
        Node head = toDList(root);
        while(head != null) {
            System.out.print(head.val);
            head = head.right;
        }
    }

    private static Node toDList(Node head) {
        if(head == null) {
            return head;
        }
        Node last = process(head);
        Node first = last.right;
        last.right = null;
        return first;
    }

    private static Node process(Node head) {
        if (head == null) {
            return head;
        }
        Node leftE = process(head.left);
        Node leftS = leftE != null ? leftE.right : null;
        Node rightE = process(head.right);
        Node rightS = rightE != null ? rightE.right : null;
        if(leftE != null && rightE != null) {
            leftE.right = head;
            head.left = rightE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if(leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if(rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }

    }
}
