package chapter3_binary_tree_problem;

public class Problem_02_PrintEdgeNodes {
    public static void printEdge1(Node head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] arr = new Node[height][2];
        traversal(arr, head, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0].value + " ");
        }

        printLeaf(head,arr,0);

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][1] != arr[i][0]) {
                System.out.print(arr[i][1].value + " ");
            }
        }
        System.out.println();
    }

    private static void printLeaf(Node head, Node[][] arr, int height) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null && arr[height][0] != head && arr[height][1] != head) {
            System.out.print(head.value+" ");
        }
        if (head.left != null) {
            printLeaf(head.left, arr, height + 1);
        }
        if (head.right != null) {
            printLeaf(head.right, arr, height + 1);
        }

    }

    private static void traversal(Node[][] arr, Node head, int height) {
        if (head == null) {
            return;
        }
        if (arr[height][0] == null) {
            arr[height][0] = arr[height][1] = head;
        } else {
            arr[height][1] = head;
        }
        traversal(arr, head.left, height + 1);
        traversal(arr, head.right, height + 1);
    }

    private static int getHeight(Node head, int height) {
        if (head == null) {
            return height;
        }
        return Math.max(getHeight(head.left, height + 1), getHeight(head.right, height + 1));
    }

    public static void printEdge2(Node head) {
        // Todo 没懂延申路径的意思
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.right.left = new Node(7);
        head.left.right.right = new Node(8);
        head.right.left.left = new Node(9);
        head.right.left.right = new Node(10);
        head.left.right.right.right = new Node(11);
        head.right.left.left.left = new Node(12);
        head.left.right.right.right.left = new Node(13);
        head.left.right.right.right.right = new Node(14);
        head.right.left.left.left.left = new Node(15);
        head.right.left.left.left.right = new Node(16);

        printEdge1(head);
        printEdge2(head);

    }
}
