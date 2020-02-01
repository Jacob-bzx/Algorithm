package chapter2_list_problem;

public class Problem_12_ConvertEveryKNodesInList {
    public static Node reverseKNodes1(Node head, int K) {
        if (head == null || K < 2) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next=head;

        Node cur = head;
        Node preNode = dummy;
        Node from = head;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == K) {
                reverse(preNode, from, cur, cur.next);

                count = 0;
                preNode = from;
                from=preNode.next;
                cur=preNode;
            }
            cur=cur.next;
        }
        return dummy.next;


    }

    public static void reverse(Node left, Node from, Node to, Node right) {
        Node pre = null;
        Node cur = from;
        while (cur != right) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        left.next = to;
        from.next = right;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        System.out.println("=======================");

    }
}
