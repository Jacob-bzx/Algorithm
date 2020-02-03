package chapter8_array_and_matrix;

public class Problem_14_SortNaturalNumberArray {

    public static void sort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            while (arr[i] != i + 1) {
                swap(arr, arr[i] - 1, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 6, 9, 3, 7, 5, 4};
        sort1(arr);
        printArray(arr);
    }

}
