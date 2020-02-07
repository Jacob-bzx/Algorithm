package chapter8_array_and_matrix;


public class Problem_23_PartitionArray {

    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                swap(arr, i, ++index);
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
        int[] arr1 = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        printArray(arr1);
        leftUnique(arr1);
        printArray(arr1);

        System.out.println();

        int[] arr2 = {2, 1, 2, 0, 1, 1, 2, 2, 0};
        printArray(arr2);

        sort(arr2);
        printArray(arr2);

    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left=0;
        int right = arr.length;
        int i=0;
        while (i < right) {
            if (arr[i] == 0) {
                swap(arr, i++, left++);
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, --right);
            }
        }
    }

}
