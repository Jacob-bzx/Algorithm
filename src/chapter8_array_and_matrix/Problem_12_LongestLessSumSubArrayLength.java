package chapter8_array_and_matrix;

import java.util.Arrays;

public class Problem_12_LongestLessSumSubArrayLength {

    public static int maxLength1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;

        int[] sum = new int[arr.length + 1];
        int[] leftMax = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
            leftMax[i + 1] = Math.max(sum[i + 1], leftMax[i]);
        }

        for (int i = 1; i < arr.length + 1; i++) {
            int target = sum[i] - k;
            int index = findIndex(leftMax, target);
            if (index < i) {
                res = Math.max(res, i - index);
            }
        }
        return res;
    }

    private static int findIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int maxLength2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[] minSum = new int[N];
        int[] minPos = new int[N];

        minSum[N - 1] = arr[N - 1];
        minPos[N - 1] = N - 1;
        for (int i = N - 2; i >= 0; i--) {
            if (minSum[i + 1] >= 0) {
                minSum[i] = arr[i];
                minPos[i] = i;
            } else {
                minSum[i] = arr[i] + minSum[i + 1];
                minPos[i] = minPos[i + 1];
            }
        }
        int res = 0;
        int left = 0;
        int sum = minSum[0];
        int right = minPos[0];
        while (right < N) {
            if (sum <= k) {
                res = Math.max(res, right - left + 1);
                if (minPos[right] == N - 1) {
                    break;
                }
                right = minPos[right] + 1;
                sum += minSum[right];
                right = minPos[right];
            } else if (left <= right) {
                sum -= arr[left++];
            }
            else {
                if (++right < N) {
                    sum += minSum[right];
                    right = minPos[right];
                }
            }
        }
        return res;
    }


    // for test

    public static int[] generateRandomArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
        }
        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    public static int[] convert(String s) {
//        String[] strs=s.split(" ");
//        int[] res = new int[strs.length];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = Integer.parseInt(strs[i]);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(50, 10);
        printArray(arr);
        int k = 4;
        System.out.println(maxLength1(arr, k));
        System.out.println(maxLength2(arr, k));

    }
}
