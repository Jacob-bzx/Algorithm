package chapter8_array_and_matrix;

public class Problem_18_FindOneLessValueIndex {

	public static int getLessIndex(int[] arr) {
		return 0;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
		printArray(arr);
		int index = getLessIndex(arr);
		System.out.println("index: " + index + ", value: " + arr[index]);

	}

}
