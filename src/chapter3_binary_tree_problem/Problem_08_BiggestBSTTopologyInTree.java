package chapter3_binary_tree_problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem_08_BiggestBSTTopologyInTree {
    // O(N^2)
    public static int bstTopoSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int max = calTopo(head, head);
        max = Math.max(max, bstTopoSize1(head.left));
        max = Math.max(max, bstTopoSize1(head.right));
        return max;
    }

    private static int calTopo(Node cur, Node head) {
        if (cur == null) {
            return 0;
        }
        int res = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (isBSTNode(tmp, head)) {
                if (tmp.left != null && tmp.left.value < tmp.value) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null && tmp.right.value > tmp.value) {
                    q.offer(tmp.right);
                }
                res++;
            }
        }
        return res;
    }

    private static boolean isBSTNode(Node tmp, Node head) {
        if (head == null) {
            return false;
        }
        if (tmp == head) {
            return true;
        }
        if (tmp.value < head.value) {
            head = head.left;
        } else {
            head = head.right;
        }
        return isBSTNode(tmp, head);
    }

    public static class Record {
        public int l;
        public int r;

        public Record(int left, int right) {
            this.l = left;
            this.r = right;
        }
    }

    static Map<Node, Record> map = new HashMap<>();

    public static int bstTopoSize2(Node head) {
        return posOrder(head);
    }

    private static int posOrder(Node head) {
        if (head == null) {
            return 0;
        }
        int leftMax = posOrder(head.left);
        int rightMax = posOrder(head.right);
        modify(head.left, head.value, true);
        modify(head.right, head.value, false);
        Record rl = map.get(head.left);
        Record rr = map.get(head.right);
        int lbst = rl == null ? 0 : rl.l + rl.r + 1;
        int rbst = rr == null ? 0 : rr.l + rr.r + 1;
        map.put(head, new Record(lbst, rbst));
        return Math.max(lbst + rbst + 1, Math.max(leftMax, rightMax));
    }

    private static int modify(Node cur, int value, boolean isLeft) {
        if (cur == null || !map.containsKey(cur)) {
            return 0;
        }
        Record r = map.get(cur);
        if ((isLeft && cur.value > value) || (!isLeft && cur.value < value)) {
            map.remove(cur);
            return r.l + r.r + 1;
        }
        int minus = modify(isLeft ? cur.right : cur.left, value, isLeft);
        if (isLeft) {
            r.r-=minus;
        } else {
            r.l-=minus;
        }
        // map.put(cur, r);
        return minus;
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
        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);
        printTree(head);

        System.out.println(bstTopoSize1(head));
        System.out.println(bstTopoSize2(head));

    }
}
