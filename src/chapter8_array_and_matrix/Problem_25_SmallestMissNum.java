package chapter8_array_and_matrix;


public class Problem_25_SmallestMissNum {

    public static int missNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            while (arr[i] != i + 1 && arr[i] > 0 && arr[i] <= N && arr[i]!=arr[arr[i]-1]) {
                swap(arr, i, arr[i] - 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] != i+1) {
                return i+1;
            }
        }
        return N+1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 6, 1, 1, 3, 5};
        System.out.println(missNum(arr));


    }
}
