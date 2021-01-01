import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author laynewei
 * @e-mail lengning_wei@berkeley.edu
 */
public class MaxMatrixSize {
    public static int getMaxSize(int[][] matrix ){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                heights[j] = matrix[i][j] == 0 ? 0 : heights[j] + 1;
            }
            int cur = getSize(heights);
            res = Math.max(cur, res);
        }
        return res;
    }

    public static int getSize(int[] heights) {
        int res = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - k  -  1) * heights[j];
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int area = (heights.length - k - 1) * heights[j];
            res = Math.max(res, area);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            for(int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }
        System.out.println(getMaxSize(matrix));
    }

}
