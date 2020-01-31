package chapter2_list_problem;

public class Problem_05_ReversePartList {
    public static Node reversePart(Node head, int from, int to) {
        int count = 0;
        Node cur = head;
        Node fromPre = null, toNext = null;
        Node fromNode = null, toNode = null;
        while (cur != null) {
            count++;
            if (count == from - 1) {
                fromPre = cur;
            }
            if (count == from) {
                fromNode = cur;
            }
            if (count == to) {
                toNode = cur;
            }
            if (count == to + 1) {
                toNext = cur;
            }
            cur = cur.next;
        }
        if (to <= from || from < 1 || to > count) {
            return head;
        }

        cur = fromNode;
        Node pre = null;
        while (cur != toNext) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        fromNode.next = toNext;

        if (fromPre != null) {
            fromPre.next = toNode;
            return head;
        } else {
            return toNode;
        }

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
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        head = reversePart(head, 1, 2);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 2, 3);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 1, 3);
        printLinkedList(head);

    }
}
