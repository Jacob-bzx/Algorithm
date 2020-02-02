package chapter8_array_and_matrix;

import java.util.HashMap;
import java.util.Map;

public class Problem_06_FindKMajority {
    public static void printHalfMajor(int[] arr) {
        if (arr == null) {
            System.out.println("没有这样的数");
            return;
        }
        final int N = arr.length;
        int count = 0;
        int res = arr[0];
        for (int num : arr) {
            if (count == 0) {
                count++;
                res = num;
            } else {
                if (res == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == res) {
                count++;
            }
        }
        if (count > N / 2) {
            System.out.println("超过一半的数是： " + res);
        } else {
            System.out.println("没有这样的数");
        }
    }

    public static void printKMajor(int[] arr, int K) {
        if (arr == null || K < 1 || arr.length == 0) {
            System.out.println("没有这样的数");
        }
        final int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                if (map.size() < K) {
                    map.put(num, 1);
                } else {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == 1) {
                            map.remove(entry.getKey());
                        } else {
                            map.put(entry.getKey(), entry.getValue() - 1);
                        }
                    }
                }
            }
        }
        for (int key : map.keySet()) {
            int count = 0;
            for (int num : arr) {
                if (num == key) {
                    count++;
                }
            }
            if (count <= N / K) {
                map.remove(key);
            } else {
                System.out.println(String.format("数字 %s 满足条件", key));
            }
        }


    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 1};
        printHalfMajor(arr);
        int K = 4;
        printKMajor(arr, K);
    }
}
