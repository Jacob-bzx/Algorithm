package chapter8_array_and_matrix;

import java.util.Arrays;

public class Problem_17_SubMatrixMaxSum {

    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int res = 0;
        int M = m.length;
        int N = m[0].length;
        for (int i = 0; i < M; i++) {
            int[] sum = new int[N];
            for (int j = i; j < M; j++) {
                for (int t = 0; t < N; t++) {
                    sum[t] += m[j][t];
                }
                int tmp = sum[0];
                int preSum = sum[0];
                for (int t = 1; t < N; t++) {
                    if (preSum <= 0) {
                        preSum = 0;
                    }
                    preSum += sum[t];
                    tmp = Math.max(tmp, preSum);
                }
                res = Math.max(res, tmp);


            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] matrix = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(maxSum(matrix));

    }

}
