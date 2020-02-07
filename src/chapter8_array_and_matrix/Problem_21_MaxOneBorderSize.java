package chapter8_array_and_matrix;

public class Problem_21_MaxOneBorderSize {

    public static int getMaxSize(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }

        int N = m.length;
        int[][] right = new int[N][N];
        int[][] down = new int[N][N];
        int res=0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (j == N - 1) {
                    right[i][j] = m[i][j];
                } else {
                    right[i][j] = m[i][j] == 0 ? 0 : right[i][j + 1] + 1;
                }
            }
        }

        for (int j = N - 1; j >= 0; j--) {
            for (int i = N - 1; i >= 0; i--) {
                if (i == N - 1) {
                    down[i][j] = m[i][j];
                } else {
                    down[i][j] = m[i][j] == 0 ? 0 : down[i + 1][j] + 1;
                }
            }
        }
//        System.out.println("=====");
//        printMatrix(right);
//        System.out.println("=====");
//        printMatrix(down);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int t = res+1; t< N; t++) {
                    if (Math.max(i, j) + t - 1 >= N || m[i][j]==0) {
                        break;
                    }

                    if (right[i][j] >= t && down[i][j] >= t && down[i][j + t - 1] >= t && right[i + t - 1][j] >= t) {
                        res=t;
                    }

                }
            }
        }
        return res;
    }


    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
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
        int[][] matrix = generateRandom01Matrix(7, 7);
        printMatrix(matrix);
        System.out.println(getMaxSize(matrix));
    }
}
