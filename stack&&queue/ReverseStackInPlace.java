import java.util.*;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class ReverseStackInPlace {
    private Deque<Integer> stack;

    public ReverseStackInPlace(){
        this.stack = new ArrayDeque<>();
    }

    public int removeBottom() {
        int res = stack.pop();
        if(stack.isEmpty()) {
            return res;
        } else {
            int last = removeBottom();
            stack.push(res);
            return last;
        }
    }

    public void reverse() {
        if(stack.isEmpty()) {
            return;
        }
        int res = removeBottom();
        reverse();
        stack.push(res);
    }


    public static void main(String[] args) {
        ReverseStackInPlace r = new ReverseStackInPlace();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> help = new ArrayDeque<>();
        scanner.nextLine();

        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            r.stack.push(num);
            help.push(num);
        }
        r.reverse();
        while(!r.stack.isEmpty()){
            System.out.print(r.stack.pop() + " ");
        }
    }
}
