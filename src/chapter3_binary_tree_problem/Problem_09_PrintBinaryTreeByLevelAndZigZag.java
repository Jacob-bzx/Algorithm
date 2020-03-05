package chapter3_binary_tree_problem;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_09_PrintBinaryTreeByLevelAndZigZag {
    public static void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        Node nlast = head;
        Node last = head;
        q.offer(head);
        System.out.print("Level " + (level++) + " :");
        while (!q.isEmpty()) {
            head = q.poll();
            if (head.left != null) {
                q.offer(head.left);
                nlast = head.left;
            }
            if (head.right != null) {
                q.offer(head.right);
                nlast = head.right;
            }
            System.out.print(head.value + " ");
            if (head == last && !q.isEmpty()) {
                System.out.println();
                System.out.print("Level " + (level++) + " :");
                last = nlast;
            }
        }
        System.out.println();
    }


    public static void printByZigZag(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offerFirst(head);
        boolean left2right = true;
        int level = 1;
        Node last = head;
        Node nlast = null;
        while (!deque.isEmpty()) {
            System.out.print("Level " + (level++) + " : ");
            while (left2right && !deque.isEmpty()) {
                Node node = deque.removeFirst();

                if (node.left != null) {
                    deque.offerLast(node.left);
                    nlast = nlast==null?node.left:nlast;
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                    nlast = nlast==null?node.right:nlast;
                }
                if (node == last) {
                    left2right = !left2right;
                    last = nlast;
                }
                System.out.print(node.value + " ");
            }

            System.out.println();
            System.out.print("Level " + (level++) + " : ");
            nlast=null;
            while (!left2right && !deque.isEmpty()) {
                Node node = deque.removeLast();

                if (node.right != null) {
                    deque.offerFirst(node.right);
                    nlast = nlast==null?node.right:nlast;
                }
                if (node.left != null) {
                    deque.offerFirst(node.left);
                    nlast = nlast==null?node.left:nlast;
                }
                if (node == last) {
                    left2right = !left2right;
                    last = nlast;
                }
                System.out.print(node.value + " ");

            }
            System.out.println();
            nlast=null;

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
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.right.left.left = new Node(7);
        head.right.left.right = new Node(8);

        printTree(head);

        System.out.println("===============");
        printByLevel(head);

        System.out.println("===============");
        printByZigZag(head);

    }

}
