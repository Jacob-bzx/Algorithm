package chapter2_list_problem;

public class Problem_16_ListSelectionSort {
    public static Node selectionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(-1);
        Node newHeadDummy = new Node(-1);
        Node newPre = newHeadDummy;
        dummy.next=head;

        while (dummy.next != null) {
            Node cur = dummy.next;
            Node pre = dummy;
            Node selected = cur;
            Node preSelected=pre;
            while (cur != null) {
                if (cur.value < selected.value) {
                    selected=cur;
                    preSelected=pre;
                }
                cur=cur.next;
                pre=pre.next;
            }

            preSelected.next=preSelected.next.next;
            newPre.next=selected;
            newPre=newPre.next;
        }
        return newHeadDummy.next;
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
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

    }
}
