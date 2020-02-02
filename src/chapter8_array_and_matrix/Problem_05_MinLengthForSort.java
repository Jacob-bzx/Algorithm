package chapter8_array_and_matrix;

public class Problem_05_MinLengthForSort {
    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        final int N = arr.length;
        int min = arr[N - 1];
        int minIndex = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (min >= arr[i]) {
                min = arr[i];
            } else {
                minIndex = i;
            }
        }
        if (minIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int maxIndex = -1;
        for (int i = 1; i <= N - 1; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            } else {
                maxIndex = i;
            }
        }
        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(getMinLength(arr));

    }
}
