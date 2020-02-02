package chapter8_array_and_matrix;

public class Problem_09_PrintUniquePairAndTriad {
    public static void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                if (left == 0 || arr[left] != arr[left - 1]) {
                    System.out.println(String.format("(%s, %s)", arr[left], arr[right]));
                }
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int target = k - arr[i];
            int left=i+1;
            int right=arr.length-1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    if (left == i+1 || arr[left] != arr[left - 1]) {
                        System.out.println(String.format("(%s, %s, %s)", arr[i], arr[left], arr[right]));
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int sum = 10;
        int[] arr1 = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printArray(arr1);
        System.out.println("====");
        printUniquePair(arr1, sum);
        System.out.println("====");
        printUniqueTriad(arr1, sum);

    }
}
