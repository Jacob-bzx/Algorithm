package chapter8_array_and_matrix;

public class Problem_19_SubArrayMaxProduct {

	public static double maxProduct(double[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		double min = arr[0], max = arr[0];
		double res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			double tmp1=min * arr[i];
			double tmp2 = max * arr[i];
			min = Math.min(Math.min(tmp1,tmp2), arr[i]);
			max = Math.max(Math.max(tmp1, tmp2), arr[i]);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
		System.out.println(maxProduct(arr));

	}

}
