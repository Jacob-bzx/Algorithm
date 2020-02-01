package chapter2_list_problem;

public class Problem_08_SmallerEqualBigger {
    public static Node listPartition(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node leftDummy = new Node(-1);
        Node equalDummy = new Node(-1);
        Node rightDummy = new Node(-1);
        Node curLeft = leftDummy;
        Node curEqual = equalDummy;
        Node curRight = rightDummy;

        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < pivot) {
                curLeft.next = head;
                curLeft=head;
            } else if (head.value == pivot) {
                curEqual.next=head;
                curEqual=head;
            } else {
                curRight.next=head;
                curRight=head;
            }
            head=next;
        }

        curEqual.next=rightDummy.next;
        curLeft.next=equalDummy.next;
        return leftDummy.next;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition(head1, 5);
        printLinkedList(head1);

    }
}
