package chapter8_array_and_matrix;

public class Problem_18_FindOneLessValueIndex {

    public static int getLessIndex(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        if (arr[0] < arr[1]) {
            return 0;
        }
        int N = arr.length;
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int left = 1, right = N - 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(arr, mid)) {
                return mid;
            }
            if (arr[mid] < arr[mid + 1]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private static boolean check(int[] arr, int mid) {
        return arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1];
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 4, 6, 7, 8};
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }

}
