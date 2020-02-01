package chapter2_list_problem;

public class Problem_19_MergeTwoLinkedLists {
    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node pre = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if (head1 != null) {
            pre.next = head1;
        }
        if (head2 != null) {
            pre.next = head2;
        }
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

        Node head1 = null;
        Node head2 = null;
        Node head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = null;
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = null;
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head2 = new Node(2);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(2);
        head2 = new Node(1);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(4);
        head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head = merge(head1, head2);
        printLinkedList(head);

        head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(9);
        head2 = new Node(0);
        head2.next = new Node(6);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head = merge(head1, head2);
        printLinkedList(head);

    }
}
