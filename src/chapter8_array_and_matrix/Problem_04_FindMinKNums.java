package chapter8_array_and_matrix;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_04_FindMinKNums {
    private static int[] getMinKNumsByHeap1(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr;
        }
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : arr) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;

    }

    private static int[] getMinKNumsByHeap2(int[] arr, int k) {
        if (arr == null || k >= arr.length) {
            return arr;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        heapInit(res);

        for (int i = k; i < arr.length; i++) {
            if (res[0] > arr[i]) {
                res[0] = arr[i];
                heapify(res);
            }
        }
        return res;

    }

    private static void heapify(int[] res) {
        int parentIndex = 0;
        down(res,0);
    }

    private static void down(int[] arr, int parentIndex) {
        int k = arr.length;
        while (parentIndex < k) {
            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = 2 * parentIndex + 2;
            int maxIndex = parentIndex;
            if (leftIndex < k) {
                maxIndex = arr[leftIndex] > arr[parentIndex] ? leftIndex : parentIndex;
            }
            if (rightIndex < k) {
                maxIndex = arr[maxIndex] >= arr[rightIndex] ? maxIndex : rightIndex;
            }
            if (maxIndex == parentIndex) {
                break;
            }
            swap(arr, maxIndex, parentIndex);
            parentIndex = maxIndex;
        }
    }

    private static void heapInit(int[] arr) {
        int k = arr.length;
        for (int i = (k - 1) / 2; i >= 0; i--) {
            down(arr, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int[] getMinKNumsByBFPRT(int[] arr, int k) {
        if (arr == null || k >= arr.length) {
            return arr;
        }

        int left=0,right=arr.length-1;
        while (true) {
            int index = partition(arr, left, right);
            if (index == k) {
                return Arrays.copyOf(arr, k);
            } else if (index < k) {
                left=index+1;
            } else {
                right=index-1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        if (left > right) {
            throw new RuntimeException("Left > Right");
        }
        if (left == right) {
            return left;
        }

        int tmp = arr[right];
        int cur = left;
        int swapIndex=left;
        while (cur < right) {
            if (arr[cur] < tmp) {
                swap(arr, cur, swapIndex++);
            }
            cur++;
        }
        swap(arr, swapIndex, cur);
        return swapIndex;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap1(arr, 10));
        printArray(getMinKNumsByHeap2(arr, 10));
        printArray(getMinKNumsByBFPRT(arr, 10));

    }




}
