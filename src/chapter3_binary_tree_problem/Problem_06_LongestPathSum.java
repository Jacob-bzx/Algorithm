package chapter3_binary_tree_problem;

import java.util.HashMap;

public class Problem_06_LongestPathSum {
    static int res;
    static HashMap<Integer, Integer> map;

    private static int getMaxLength(Node head, int sum) {
        map = new HashMap<>();
        res=0;
        if (head == null) {
            return 0;
        }
        map.put(0, -1);
        dfs(head, sum, 0, 0);
        return res;
    }

    private static void dfs(Node head, int targetSum, int curSum, int height) {
        curSum += head.value;
        int diff = curSum - targetSum;

        if (map.containsKey(diff)) {
            res = Math.max(res, height - map.get(diff));
        }
        map.putIfAbsent(curSum, height);

        if (head.left != null) {
            dfs(head.left, targetSum, curSum, height + 1);
        }
        if (head.right != null) {
            dfs(head.right, targetSum, curSum, height + 1);
        }
        if (map.get(curSum) == height) {
            map.remove(curSum);
        }
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(3);
        head.right = new Node(-9);
        head.left.left = new Node(1);
        head.left.right = new Node(0);
        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.right.left = new Node(2);
        head.right.right = new Node(1);
        printTree(head);
        System.out.println(getMaxLength(head, 6));
        System.out.println(getMaxLength(head, -9));

    }
}
