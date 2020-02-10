package chapter8_array_and_matrix;

public class Problem_31_ContainWater {
    public static int getVolume(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int res = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left++]);
            } else {
                res += Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getVolume(new int[]{3, 1, 2, 5, 2, 4}));
        System.out.println(getVolume(new int[]{4, 5, 1, 3, 2}));
    }
}
