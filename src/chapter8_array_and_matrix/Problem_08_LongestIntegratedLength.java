package chapter8_array_and_matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_08_LongestIntegratedLength {

    public static int getLIL1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j - i <= res) {
                    continue;
                }
                if (check(arr, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static boolean check(int[] arr, int left, int right) {
        int[] tmp = Arrays.copyOfRange(arr, left, right + 1);
        Arrays.sort(tmp);
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i - 1] - tmp[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static int getLIL2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res=0;
        for (int i = 0; i < arr.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++){
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                if (max - min + 1 == j - i + 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 3, 2, 6, 4, 3};
        System.out.println(getLIL1(arr));
        System.out.println(getLIL2(arr));

    }
}
