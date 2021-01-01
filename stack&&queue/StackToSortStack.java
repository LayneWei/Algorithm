import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 * @description using one stack to sort another stack
 */

public class StackToSortStack {
    private Deque<Integer> stack;
    private Deque<Integer> helper;

    public StackToSortStack(){
        this.stack = new ArrayDeque<>();
        this.helper = new ArrayDeque<>();
    }

    public void sort() {
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!helper.isEmpty() && helper.peekFirst() < temp) {
                stack.push(helper.pop());
            }
            helper.push(temp);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        StackToSortStack S = new StackToSortStack();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        for(int i = 0; i< n; i++) {
            S.stack.push(Integer.parseInt(strArr[i]));
        }
        S.sort();
        while(!S.stack.isEmpty()) {
            System.out.print(S.stack.pop() + " ");
        }
    }
}
