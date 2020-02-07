package chapter8_array_and_matrix;

public class Problem_26_MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int N = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if (max == min) {
            return 0;
        }


        int[] maxs = new int[N + 1];
        int[] mins = new int[N + 1];
        boolean[] hasNumbers = new boolean[N + 1];

        for (int num : nums) {
            int index = (num - min) * N / (max - min);
            maxs[index] = hasNumbers[index] ? Math.max(maxs[index], num) : num;
            mins[index] = hasNumbers[index] ? Math.min(mins[index], num) : num;
            hasNumbers[index] = true;
        }
        int pre = maxs[0];
        int res = maxs[0] - mins[0];

        for (int i = 0; i <= N; i++) {
            if (hasNumbers[i]) {
                res = Math.max(res, mins[i] - pre);
                pre = maxs[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {11, 10, 9, 3, 1, 12};
        System.out.println(maxGap(arr));
    }

}
