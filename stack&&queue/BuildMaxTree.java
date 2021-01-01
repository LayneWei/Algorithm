import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class BuildMaxTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode BuildTree(int[] arr) {
        TreeNode head = null;
        int n = arr.length;
        TreeNode[] nArr = new TreeNode[n];
        for(int i = 0; i < arr.length; i++) {
            nArr[i] = new TreeNode(arr[i]);
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> lBiggerIndex = new HashMap<>();
        HashMap<TreeNode,TreeNode> rBiggerIndex = new HashMap<>();
        for(int i = 0; i<n; i++) {
            TreeNode cur = nArr[i];
            while(!stack.isEmpty() && cur.val > stack.peekFirst().val) {
                popAndRecord(stack,lBiggerIndex);
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()) {
            popAndRecord(stack,lBiggerIndex);
        }
        for(int i = n - 1; i >= 0; i--) {
            TreeNode cur =  nArr[i];
            while(!stack.isEmpty() && cur.val > stack.peekFirst().val) {
                popAndRecord(stack,rBiggerIndex);
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()) {
            popAndRecord(stack,rBiggerIndex);
        }

        for(int i = 0; i < n; i++) {
            TreeNode cur = nArr[i];
            TreeNode left = lBiggerIndex.get(cur);
            TreeNode right = rBiggerIndex.get(cur);
            if(left == null && right == null) {
                head = cur;
            } else if(left == null) {
                if(right.left == null) {
                    right.left = cur;
                } else {
                    right.right = cur;
                }
            } else if(right == null) {
                if (left.left == null) {
                    left.left = cur;
                } else {
                    left.right = cur;
                }
            } else {
                TreeNode parent = left.val < right.val ? left : right;
                if(parent.left == null) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
            }
        }
        return head;
    }

    public static void popAndRecord(Deque<TreeNode> stack, HashMap<TreeNode,TreeNode> map) {
        TreeNode cur = stack.pop();
        if(stack.isEmpty()) {
            map.put(cur,null);
        } else {
            map.put(cur,stack.peekFirst());
        }
    }

    public static void preOrder(TreeNode head) {
        if(head == null) {
            return;
        }
        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            arr[i] = num;
        }
        preOrder(BuildTree(arr));
    }
}
