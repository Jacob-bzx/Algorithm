package chapter8_array_and_matrix;

public class Problem_13_SmallSum {

    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        return sort(arr, 0, N - 1);
    }

    private static int sort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftVal = sort(arr, left, mid);
        int rightVal = sort(arr, mid + 1, right);
        int[] res = new int[right - left + 1];

        // merge
        int cur1 = left, cur2 = mid + 1;
        int index = 0;
        int sum = 0;
        int tmp = 0;
        while (cur1 <= mid && cur2 <= right) {
            if (arr[cur1] <= arr[cur2]) {
                tmp += arr[cur1];
                res[index++] = arr[cur1++];
            } else {
                sum += tmp;
                res[index++] = arr[cur2++];
            }
        }
        while (cur1 <= mid) {
            res[index++] = arr[cur1++];
        }
        while (cur2 <= right) {
            sum += tmp;
            res[index++] = arr[cur2++];
        }
        System.arraycopy(res,0,arr,left,res.length);

        return sum + leftVal + rightVal;
    }

    // for test

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11);
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        System.out.println(getSmallSum(arr.clone()));
    }

}
