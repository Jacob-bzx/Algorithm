package chapter8_array_and_matrix;

public class Problem_03_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int row1 = 0, col1=0,row2=0,col2=0;
        boolean upToDown=false;
        while (row1 < M) {
            printMatrixZigZag(row1, col1, row2, col2, upToDown, matrix);
            upToDown=!upToDown;
            if(col1<N-1){
                col1++;
            } else {
                row1++;
            }

            if (row2 < M-1) {
                row2++;
            } else {
                col2++;
            }
        }
    }

    private static void printMatrixZigZag(int row1, int col1, int row2, int col2, boolean upToDown, int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        if (upToDown) {
            int row = row1, col=col1;
            while (row <= row2) {
                System.out.print(matrix[row++][col--]+" ");
            }
        } else {
            int row = row2, col=col2;
            while (row >= row1) {
                System.out.print(matrix[row--][col++]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }
}
