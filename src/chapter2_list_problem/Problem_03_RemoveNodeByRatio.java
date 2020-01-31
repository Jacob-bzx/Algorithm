package chapter2_list_problem;

public class Problem_03_RemoveNodeByRatio {
    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static Node removeByRatio(Node head, int a, int b) {
        if (head == null || a > b) {
            return head;
        }
        int length = 0;
        Node cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int index = (int) Math.ceil(a * 1.0 * length / b);
        Node dummy = new Node(0);
        dummy.next = head;
        cur = dummy;
        while (--index > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;


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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printLinkedList(head);
        head = removeMidNode(head);
        printLinkedList(head);
        head = removeByRatio(head, 2, 5);
        printLinkedList(head);
        head = removeByRatio(head, 1, 3);
        printLinkedList(head);

    }
}
