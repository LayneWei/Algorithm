import java.util.*;
/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 *
 * @description implement a stack that has O(1) time for getMin(),
 * should also support push(), pop()
 */

// implement a stack that has
public class GetMinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public GetMinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public  void push(Integer item) {
        this.stack.push(item);
        if(minStack.isEmpty() || item <= minStack.peek()) {
            this.minStack.push(item);
        }
    }

    public int pop() {
        if(stack.size() == 0) {
            throw new RuntimeException("your stack is empty");
        }
        if(stack.peek() == minStack.peek()) {
            minStack.pop();
            return stack.pop();
        } else {
            return stack.pop();
        }
    }

    public int getMin() {
        if(minStack.size() == 0) {
            throw new RuntimeException("your stack is empty");
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        GetMinStack m = new GetMinStack();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();
        for(int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            if(str.equals("getMin")) {
                System.out.println(m.getMin());
            } else if (str.equals("pop")) {
                m.pop();
            } else {
                String[] strArr = str.split(" ");
                Integer num = Integer.parseInt(strArr[1]);
                m.push(num);
            }
        }
    }
}
