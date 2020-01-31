package chapter2_list_problem;

public class Problem_01_PrintCommonPart {
    public static void printCommonPart(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return;
        }
        while (head1 != null && head2 != null) {
            int v1 = head1.value;
            int v2 = head2.value;
            if(v1==v2){
                System.out.print(v1+" ");
                head1=head1.next;
                head2=head2.next;
            } else if(v1>v2){
                head2=head2.next;
            } else {
                head1=head1.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
