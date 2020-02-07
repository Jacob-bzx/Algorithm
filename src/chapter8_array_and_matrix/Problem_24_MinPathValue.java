package chapter8_array_and_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_24_MinPathValue {
    public static class Point {
        int row;
        int col;
        int val;

        public Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    static int[][] map;

    public static int minPathValue(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] == 0 || m[m.length - 1][m[0].length - 1] == 0) {
            return 0;
        }
        int M = m.length;
        int N = m[0].length;
        int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        map = new int[M][N];
        map[0][0] = 1;
        int res = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int[] moveTmp : move) {
                int newRow = tmp.row + moveTmp[0];
                int newCol = tmp.col + moveTmp[1];
                if (newRow >= 0 && newRow < M && newCol >= 0 && newCol < N && m[newRow][newCol]==1 && map[newRow][newCol] != 1) {
                    if (newRow == M - 1 && newCol == N - 1) {
                        return tmp.val + 1;
                    }
                    q.offer(new Point(newRow, newCol, tmp.val + 1));
                    map[newRow][newCol] = 1;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1}};
        System.out.println(minPathValue(matrix));

    }
}
