package chapter8_array_and_matrix;

import java.util.Arrays;

public class Problem_30_GoodStartPoint {
    public static boolean[] getGoodStartPoint(int[] oil, int[] dis) {
        if (oil == null || oil.length < 2 || dis == null || dis.length != oil.length) {
            return null;
        }
        boolean[] res = new boolean[oil.length];
        getSimplifiedArray(oil, dis);
        int init = getInitPoint(oil);
        if (init == -1) {
            return res;
        }

        int start = init;
        int end = nextIndex(init, oil.length);
        int need = 0;
        int rest = 0;
        do {
            if (start != init && start == lastIndex(end, dis.length)) {
                break;
            }

            if (oil[start] < need) {
                need -= oil[start];
            } else {
                rest += oil[start] - need;
                need = 0;
                while (rest >= 0 && start != end) {
                    rest += oil[end];
                    end = nextIndex(end, oil.length);
                }

                if (rest >= 0) {
                    res[start] = true;
                    connectGood(oil, lastIndex(start, oil.length), init, res);
                    break;
                }
            }
            start = lastIndex(start, oil.length);
        } while (start != init);
        return res;


    }

    private static void connectGood(int[] oil, int start, int init, boolean[] res) {
        int need = 0;
        while (start != init) {
            if (need <= oil[start]) {
                res[start] = true;
                need = 0;
            } else {
                need -= oil[start];
            }
            start = lastIndex(start, oil.length);
        }
    }

    private static int getInitPoint(int[] oil) {
        for (int i = 0; i < oil.length; i++) {
            if (oil[i] >= 0) {
                return i;
            }
        }
        return -1;
    }

    private static void getSimplifiedArray(int[] oil, int[] dis) {
        for (int i = 0; i < oil.length; i++) {
            oil[i] -= dis[i];
        }
    }

    private static int lastIndex(int i, int length) {
        return (i - 1 + length) % length;
    }

    private static int nextIndex(int i, int length) {
        return (i + 1) % length;
    }

    public static void main(String[] args) {
        int[] oil = {4, 2, 0, 4, 5, 2, 3, 6, 2};
        int[] dis = {6, 1, 3, 1, 6, 4, 1, 1, 6};
        System.out.println(Arrays.toString(getGoodStartPoint(oil, dis)));

        oil = new int[]{4, 5, 3, 1, 5, 1, 1, 9};
        dis = new int[]{1, 9, 1, 2, 6, 0, 2, 0};
        System.out.println(Arrays.toString(getGoodStartPoint(oil, dis)));
    }
}
