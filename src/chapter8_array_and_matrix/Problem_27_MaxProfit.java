package chapter8_array_and_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_27_MaxProfit {
    public static class Program{
        int cost;
        int profit;

        public Program(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
    public static int maxProfit(int W, int K, int[] costs, int[] profits){
        if (costs == null || costs.length == 0) {
            return W;
        }
        Queue<Program> q1 = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        Queue<Program> q2 = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);

        for (int i = 0; i < costs.length; i++) {
            q1.offer(new Program(costs[i], profits[i]));
        }

        for (int t = 0; t < K; t++) {
            while (!q1.isEmpty() && q1.peek().cost <= W) {
                q2.offer(q1.poll());
            }
            if (q2.isEmpty()) {
                return W;
            }
            W+=q2.poll().profit;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] costs = {5,4,1,2};
        int[] profits = {3,5,3,2};
        System.out.println(maxProfit(3, 2, costs, profits));
    }
}
