package chapter8_array_and_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_24_MinPathValue {

	public static int minPathValue(int[][] m) {
		return 0;
	}



	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1 } };
		System.out.println(minPathValue(matrix));

	}
}
