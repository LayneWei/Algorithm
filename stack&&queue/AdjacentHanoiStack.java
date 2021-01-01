import java.awt.desktop.SystemEventListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class AdjacentHanoiStack {
    public enum Action{
        No, LToM, MToL, MToR, RToM
    }

    public static int stackToStack(Action[] record, Action preNoAct, Action curAct,
                                   Deque<Integer> fStack, Deque<Integer> tStack, String from, String to) {
        if(record[0] != preNoAct && fStack.peekFirst() < tStack.peekFirst()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to "+ to);
            record[0] = curAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> lS = new ArrayDeque<>();
        Deque<Integer> mS = new ArrayDeque<>();
        Deque<Integer> rS = new ArrayDeque<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for(int i = n; i > 0; i--) {
            lS.push(i);
        }

        Action[] record = new Action[]{Action.No};
        int step = 0;
        while(rS.size()!=n + 1) {
            step += stackToStack(record,Action.MToL,Action.LToM,lS,mS,"left","mid");
            step += stackToStack(record,Action.LToM,Action.MToL,mS,lS,"mid","left");
            step += stackToStack(record,Action.RToM,Action.MToR,mS,rS,"mid","right");
            step += stackToStack(record,Action.MToR,Action.RToM,rS,mS,"right","mid");
        }
        System.out.println(step);
    }
}
