package chapter1_stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_10_AllLessNumSubArray {
    public static int getRes(int[] arr, int num) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < arr.length; i++) {
            while(!maxQueue.isEmpty() && arr[maxQueue.getLast()]<= arr[i]){
                maxQueue.removeLast();
            }
            while (!minQueue.isEmpty() && arr[minQueue.getLast()] >= arr[i]) {
                minQueue.removeLast();
            }

            maxQueue.offerLast(i);
            minQueue.offerLast(i);

            while (!maxQueue.isEmpty() && arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
                int maxIndex = maxQueue.getFirst();
                int minIndex = minQueue.getFirst();
                int index = Math.min(maxIndex, minIndex);
                start = index;
                if (maxIndex == index) {
                    maxQueue.removeFirst();
                }
                if (minIndex == index) {
                    minQueue.removeFirst();
                }
            }
            res += i - start;
        }
        return res;
    }
}
