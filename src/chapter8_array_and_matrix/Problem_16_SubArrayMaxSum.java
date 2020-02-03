package chapter8_array_and_matrix;

public class Problem_16_SubArrayMaxSum {

	public static int maxSum(int[] arr) {
		if(arr==null||arr.length==0){
			return 0;
		}
		int res = arr[0];
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum <= 0) {
				sum=arr[i];

			} else {
				sum+=arr[i];
			}
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
		System.out.println(maxSum(arr1));

		int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
		System.out.println(maxSum(arr2));

		int[] arr3 = { -2, -3, -5, -1 };
		System.out.println(maxSum(arr3));

	}

}
