package chapter3_binary_tree_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem_01_PreInPosTraversal {
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            Node cur = s.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
    }


    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s = new Stack<>();

        Node cur = head;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur=cur.left;
            } else {
                cur=s.pop();
                System.out.print(cur.value+" ");
                cur=cur.right;
            }
        }
    }

    public static void posOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(head);
        while (!s.isEmpty()) {
            Node cur = s.pop();
            res.add(cur.value);
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }
        Collections.reverse(res);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderUnRecur(head);

    }

}
