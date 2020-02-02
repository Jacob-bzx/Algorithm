package chapter8_array_and_matrix;

public class Problem_23_PartitionArray {

	public static void leftUnique(int[] arr) {

	}



	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		printArray(arr1);
		leftUnique(arr1);
		printArray(arr1);

		System.out.println();

		int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
		printArray(arr2);
		// sort(arr2);
		printArray(arr2);

	}

}
