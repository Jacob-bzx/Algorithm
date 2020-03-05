package chapter3_binary_tree_problem;

public class Problem_07_BiggestSubBSTInTree {
    public static Node biggestSubBST(Node head) {
        if (head == null) {
            return head;
        }
        return process(head).node;
    }

    private static class ReturnType {
        int min;
        int max;
        Node node;
        int number;

        public ReturnType(int min, int max, Node node, int number) {
            this.min = min;
            this.max = max;
            this.node = node;
            this.number = number;
        }
    }


    private static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, 0, null, -1);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType = process(head.right);
        // 叶子节点
        if (leftReturnType.number == -1 && rightReturnType.number == -1) {
            return new ReturnType(head.value, head.value, head, 1);
        }
        // 无左节点
        else if (leftReturnType.number == -1) {
            if (head.value < rightReturnType.min) {
                return new ReturnType(head.value, rightReturnType.max, head, rightReturnType.number + 1);
            } else {
                return rightReturnType;
            }
        }
        // 无右节点
        else if (rightReturnType.number == -1) {
            if (head.value > leftReturnType.max) {
                return new ReturnType(leftReturnType.min, head.value, head, leftReturnType.number + 1);
            } else {
                return leftReturnType;
            }
        }
        // 有左右节点
        else {
            if (head.value > leftReturnType.max && head.value < rightReturnType.min && head.left==leftReturnType.node && head.right==rightReturnType.node) {
                return new ReturnType(leftReturnType.min, rightReturnType.max, head, leftReturnType.number + rightReturnType.number + 1);
            } else {
                return leftReturnType.number > rightReturnType.number ? leftReturnType : rightReturnType;
            }
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
        Node bst = biggestSubBST(head);
        printTree(bst);

    }
}
