package chapter2_list_problem;

public class Problem_10_AddTwoLinkedLists {
    public static Node addLists1(Node head1, Node head2) {
        Node newHead1 = reverse(head1);
        Node newHead2 = reverse(head2);
        Node dummy = new Node(-1);
        Node cur = dummy;
        int carry = 0;
        while (newHead1 != null || newHead1 != null) {
            int val1 = newHead1 == null ? 0 : newHead1.value;
            int val2 = newHead2 == null ? 0 : newHead2.value;
            int val = val1 + val2 + carry;
            if (val >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            val %= 10;
            cur.next = new Node(val);
            cur = cur.next;
            if (newHead1 != null) {
                newHead1 = newHead1.next;
            }
            if(newHead2!=null) {
                newHead2 = newHead2.next;
            }
        }
        if (carry == 1) {
            cur.next = new Node(1);
        }
        return reverse(dummy.next);
    }

    public static Node reverse(Node head) {
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(1);

        printLinkedList(head1);
        printLinkedList(head2);
        printLinkedList(addLists1(head1, head2));

    }
}
