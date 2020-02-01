package chapter3_binary_tree_problem;

public class Problem_05_MorrisTraversal {

    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            } else {
                System.out.print(cur.value + " ");
                Node mostRight = find(cur);
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static Node find(Node head) {
        Node cur = head.left;
        while (cur.right != null && cur.right != head) {
            cur = cur.right;
        }
        return cur;
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            } else {
                Node mostRight = find(cur);
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            } else {
                Node mostRight = find(cur);
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                Node mostRight = find(cur);
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    printRightEdge(cur.left);
                    cur=cur.right;
                }
            }
        }
        printRightEdge(head);
        System.out.println();
    }

    private static void printRightEdge(Node head) {
        if (head == null) {
            return;
        }
        Node start = reverse(head);
        Node cur = start;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur=cur.right;
        }
        reverse(start);
    }

    private static Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = null;
        while (head != null) {
            Node next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        System.out.print("Morris: ");
        morris(head);
        System.out.print("In: ");
        morrisIn(head);
        System.out.print("Pre: ");
        morrisPre(head);
        System.out.print("Pos: ");
        morrisPos(head);
        printTree(head);

    }
}
