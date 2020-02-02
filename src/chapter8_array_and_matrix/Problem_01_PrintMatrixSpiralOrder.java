package chapter8_array_and_matrix;

public class Problem_01_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int top = 0, down = M - 1, left = 0, right = N - 1;
        while (top <= down && left <= right) {
            printEdge(top++,left++,down--,right--,matrix);
        }
    }

    public static void printEdge(int top, int left, int down, int right, int[][] matrix) {
        if (top == down) {
            for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }
            return;
        }

        if (left == right) {
            for (int row = top; row <= down; row++) {
                System.out.print(matrix[row][left] + " ");
            }
            return;
        }

        for (int col = left; col < right; col++) {
            System.out.print(matrix[top][col] + " ");
        }
        for (int row = top; row < down; row++) {
            System.out.print(matrix[row][right] + " ");
        }
        for (int col = right; col > left; col--) {
            System.out.print(matrix[down][col] + " ");
        }
        for (int row = down; row > top; row--) {
            System.out.print(matrix[row][left]+" ");
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }
}
