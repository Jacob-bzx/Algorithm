package chapter8_array_and_matrix;

public class Problem_15_EvenInEvenOddInOdd {

    public static void modify(int[] arr) {
        int evenIndex = 0, oddIndex = 1;
        while (evenIndex < arr.length && oddIndex < arr.length) {
            if ((arr[arr.length - 1] & 1) == 0) {
                swap(arr, evenIndex, arr.length - 1);
                evenIndex+=2;
            } else {
                swap(arr, oddIndex, arr.length - 1);
                oddIndex+=2;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 2, 4, 6};
        printArray(arr);
        modify(arr);
        printArray(arr);

    }

}
