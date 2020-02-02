package chapter8_array_and_matrix;

public class Problem_12_LongestLessSumSubArrayLength {

	public static int maxLength(int[] arr, int k) {
		return 0;
	}


	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3, -2, -4, 0, 6 };
		int k = -2;
		System.out.println(maxLength(arr, k));

	}
}
