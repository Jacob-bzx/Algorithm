package chapter8_array_and_matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_20_PrintMaxTopK {

    public static class HeapNode {
        int value;
        int arrayNum;
        int index;

        public HeapNode(int value, int arrayNum, int index) {
            this.value = value;
            this.arrayNum = arrayNum;
            this.index = index;
        }
    }

    public static void printTopK(int[][] matrix, int topK) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        Queue<HeapNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> -o.value));

        for (int i = 0; i < matrix.length; i++) {
            q.offer(new HeapNode(matrix[i][matrix[i].length - 1], i, matrix[i].length - 1));
        }

        while (topK-- > 0) {
            HeapNode tmp = q.poll();
            System.out.println(tmp.value);
            if(tmp.index>0) {
                q.offer(new HeapNode(matrix[tmp.arrayNum][tmp.index - 1], tmp.arrayNum, tmp.index - 1));
            }
        }
    }


    public static int[][] generateRandomMatrix(int maxRow, int maxCol,
                                               int maxValue) {
        if (maxRow < 0 || maxCol < 0) {
            return null;
        }
        int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
        for (int i = 0; i != matrix.length; i++) {
            matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
            for (int j = 0; j != matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 10, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        printTopK(matrix, 10);
    }

}
