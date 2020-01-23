package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_09_MaximalRectangle {
    public static int maxArea(int[][] arr){
        if(arr==null||arr.length==0||arr[0].length==0){
            return 0;
        }
        int M = arr.length;
        int N = arr[0].length;
        int res=0;
        int[] tmp = new int[N];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==0){
                    tmp[j]=0;
                } else {
                    tmp[j]++;
                }
            }
            for (int j = 0; j < N; j++) {
                while (!s.isEmpty() && tmp[s.peek()] >= tmp[j]) {
                    int index = s.pop();
                    int l=s.isEmpty()?-1:s.peek();
                    int r = j;
                    int area = tmp[index]*(r - l - 1);
                    res = Math.max(res, area);
                }
                s.push(j);
            }
            while(!s.isEmpty()){
                int index=s.pop();
                int l=s.isEmpty()?-1:s.peek();
                int r = N;
                int area = tmp[index]*(r - l - 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxArea(arr));
    }
}
