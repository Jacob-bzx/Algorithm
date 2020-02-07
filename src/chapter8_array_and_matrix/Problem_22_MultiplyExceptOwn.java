package chapter8_array_and_matrix;

public class Problem_22_MultiplyExceptOwn {

    public static int[] product1(int[] arr) {
        int count = 0;
        int product = 1;
        for (int num : arr) {
            if (num != 0) {
                product *= num;
            } else {
                count++;
                if (count == 2) {
                    break;
                }
            }
        }
        int[] res = new int[arr.length];
        if (count == 0) {
            for (int i = 0; i < arr.length; i++) {
                res[i] = product / arr[i];
            }
        } else if (count == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = product;
                    break;
                }
            }
        }
        return res;
    }
        public static int[] product2 (int[] arr){
            int[] res = new int[arr.length];
            res[0]=1;
            int product=arr[0];
            for (int i = 1; i < arr.length; i++) {
                res[i]=product;
                product *= arr[i];
            }

            product = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                res[i] *= product;
                product *= arr[i];
            }
            return res;
        }

        public static void printArray ( int[] arr){
            for (int i = 0; i != arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public static void main (String[]args){
            int[] arr = {1, 2, 3, 4};
            int[] res1 = product1(arr);
            printArray(res1);
            int[] res2 = product2(arr);
            printArray(res2);

        }
    }
