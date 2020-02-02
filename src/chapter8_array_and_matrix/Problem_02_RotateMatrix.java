package chapter8_array_and_matrix;

public class Problem_02_RotateMatrix {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int down = matrix[0].length - 1;
        int top = 0;
        while (top <= down) {
            rotateEdge(matrix, top++, down--);
        }

    }

    public static void rotateEdge(int[][] matrix, int top, int down) {
        if (top == down) {
            return;
        }
        int N = matrix.length;
        int left = top, right = down;
        for (int j = left; j < right; j++) {
            int tmp = matrix[top][j];
            matrix[top][j] = matrix[N - 1 - j][top];
            matrix[N - 1 - j][top] = matrix[N - 1 - top][N - 1 - j];
            matrix[N - 1 - top][N - 1 - j] = matrix[j][N - 1 - top];
            matrix[j][N - 1 - top] = tmp;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
