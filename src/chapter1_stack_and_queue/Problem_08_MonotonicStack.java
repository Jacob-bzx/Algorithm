package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_08_MonotonicStack {
    public static int[][] getArr1(int[] arr) {
        int[][] res = new int[arr.length][2];
        // 先找右边的
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                res[s.pop()][1]=i;
            }
            s.push(i);
        }
        // 处理栈中剩下的元素
        while (!s.isEmpty()) {
            res[s.pop()][1]=-1;
        }

        // 找左边第一个小的值同上
        for (int i = arr.length-1; i >=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                res[s.pop()][0]=i;
            }
            s.push(i);
        }
        // 处理栈中剩下的元素
        while (!s.isEmpty()) {
            res[s.pop()][0]=-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = getArr1(new int[]{3, 4, 1, 5, 6, 2, 7});
        for (int i = 0; i < res.length; i++) {
            System.out.println(String.format("{%s, %s}", res[i][0], res[i][1]));
        }
        System.out.println();
        res = getArr1(new int[]{3,1,3,4,3,5,3,2,2});
        for (int i = 0; i < res.length; i++) {
            System.out.println(String.format("{%s, %s}", res[i][0], res[i][1]));
        }
    }
}
