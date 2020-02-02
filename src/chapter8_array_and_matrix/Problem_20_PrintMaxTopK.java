package chapter8_array_and_matrix;

import java.util.Arrays;

public class Problem_20_PrintMaxTopK {

	public static class HeapNode {
		public int value; // 值是什么
		public int arrNum; // 来自哪个数组
		public int index; // 来自数组的哪个位置

		public HeapNode(int value, int arrNum, int index) {
			this.value = value;
			this.arrNum = arrNum;
			this.index = index;
		}
	}

	public static void printTopK(int[][] matrix, int topK) {
		return;
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
		printTopK(matrix, 100);
	}

}
