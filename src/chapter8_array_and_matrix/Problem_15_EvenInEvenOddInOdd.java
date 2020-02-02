package chapter8_array_and_matrix;

public class Problem_15_EvenInEvenOddInOdd {

	public static void modify(int[] arr) {
		return;
	}


	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 3, 2, 4, 6 };
		printArray(arr);
		modify(arr);
		printArray(arr);

	}

}
