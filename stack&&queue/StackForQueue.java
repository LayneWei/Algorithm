/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackForQueue {
    private Deque<Integer> stack;
    private Deque<Integer> helper;

    public StackForQueue(){
        this.stack = new ArrayDeque<>();
        this.helper = new ArrayDeque<>();
    }

    public void add(int x) {
        stack.push(x);
    }

    public int poll() {
        int temp = peek();
        return helper.pop();
    }

    public int peek() {
        if(!helper.isEmpty()) {
            return helper.peek();
        } else {
            if(stack.isEmpty()) {
                throw new RuntimeException("your queue is empty");
            }
            while(!stack.isEmpty()) {
                helper.push(stack.pop());
            }
            return helper.peek();
        }
    }

    public static void main(String[] args) {
        StackForQueue m = new StackForQueue();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        scan.nextLine();

        for(int i = 0; i < n; i++) {
            String str = scan.nextLine();
            if(str.equals("peek")) {
                System.out.println(m.peek());
            } else if (str.equals("poll")) {
                m.poll();
            } else{
                String[] strArr = str.split(" ");
                Integer num = Integer.parseInt(strArr[1]);
                m.add(num);
            }
        }
    }
}