package chapter3_binary_tree_problem;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_04_SerializeAndReconstructTree {


    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String leftRes = serialByPre(head.left);
        String rightRes = serialByPre(head.right);
        return String.valueOf(head.value) + "!" + leftRes + rightRes;
    }

    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> q = new LinkedList<>();
        for (String str : values) {
            q.offer(str);
        }
        return reconPreOrder(q);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        Node cur = new Node(Integer.parseInt(val));
        cur.left = reconPreOrder(queue);
        cur.right = reconPreOrder(queue);
        return cur;
    }

    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        StringBuilder res = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur == null) {
                res.append("#!");
            } else {
                res.append(cur.value).append("!");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return res.toString();
    }

    public static Node reconByLevelString(String levelStr) {
        if (levelStr.equals("#!")) {
            return null;
        }
        String[] values = levelStr.split("!");
        int index = 0;
        Queue<Node> q = new LinkedList<>();
        Node head= generateNodeByString(values[index++]);
        q.offer(head);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            cur.left = generateNodeByString(values[index++]);
            cur.right = generateNodeByString(values[index++]);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return head;

    }

    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.parseInt(val));
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
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }
}
