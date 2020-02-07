package chapter8_array_and_matrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_28_DivideMinCost {
    public static int divide(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : arr) {
            q.offer(num);
        }
        int res = 0;
        while (q.size() >1) {
            int tmp = q.poll() + q.poll();
            res+=tmp;
            q.offer(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divide(new int[]{3,9,5,2,4,4}));
    }
}
