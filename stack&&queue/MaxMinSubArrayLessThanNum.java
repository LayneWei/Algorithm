import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class MaxMinSubArrayLessThanNum {
    public static int findSubArrayNum(int[] arr, int num) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int res = 0;
        Deque<Integer> dequeMax = new ArrayDeque<>();
        Deque<Integer> dequeMin = new ArrayDeque<>();
        int l = 0, r = 0;
        while(l < n){
            //move right
            while(r < n) {
                while(!dequeMax.isEmpty() && arr[r] >= arr[dequeMax.peekLast()]) {
                    dequeMax.pollLast();
                }
                dequeMax.addLast(r);
                while(!dequeMin.isEmpty() && arr[r] <= arr[dequeMin.peekLast()]) {
                    dequeMin.pollLast();
                }
                dequeMin.addLast(r);

                if(arr[dequeMax.peekFirst()] - arr[dequeMin.peekFirst()] > num) {
                    break;
                }
                r++;
            }
            if(dequeMin.peekFirst() == l) {
                dequeMin.pollFirst();
            }
            if(dequeMax.peekFirst() == l) {
                dequeMax.pollFirst();
            }
            res += r - l;
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
        }
        System.out.println(findSubArrayNum(arr,target));
    }
}
