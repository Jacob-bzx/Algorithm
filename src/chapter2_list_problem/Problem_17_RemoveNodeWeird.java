package chapter2_list_problem;

public class Problem_17_RemoveNodeWeird {
    public static void removeNodeWired(Node node) {
        node.value=node.next.value;
        node.next=node.next.next;
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
        Node node = head;
        printLinkedList(head);
        removeNodeWired(node);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        node = head.next;
        printLinkedList(head);
        removeNodeWired(node);
        printLinkedList(head);
    }

}
