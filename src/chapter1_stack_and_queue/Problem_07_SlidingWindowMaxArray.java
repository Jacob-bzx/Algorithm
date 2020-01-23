package chapter1_stack_and_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {
    public static int[] getMaxSlidingArray(int[] arr, int w) {
        if (arr == null || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.removeLast();
            }
            q.offerLast(i);
            if (i >= w - 1) {
                res[i - w + 1] = arr[q.peekFirst()];
            }
            if (i - q.peekFirst() == w - 1) {
                q.removeFirst();
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = getMaxSlidingArray(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
