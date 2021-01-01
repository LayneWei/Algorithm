import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class WindowMaxArr {

    public static int[] getWindowMaxArr(int[] arr, int w) {
        int n = arr.length;
        int[] res = new int[n - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for(int i = 0; i< n; i++) {
            while(!list.isEmpty() && arr[i] > arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            if(list.peekFirst() == i - w) {
                list.removeFirst();
            }
            if(i >= w - 1) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int[] res = getWindowMaxArr(arr, w);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
