package chapter2_list_problem;

public class Problem_09_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRand(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node curCopy = new Node(cur.value);
            curCopy.next=next;
            curCopy.rand=cur.rand;
            cur.next = curCopy;
            cur=next;
        }
        cur=head;
        while (cur != null) {
            if (cur.next.rand != null) {
                cur.next.rand=cur.next.rand.next;
            }
            cur=cur.next.next;
        }

        cur = head;
        Node pre = dummy;
        while (cur != null) {
            Node next = cur.next.next;
            pre.next=cur.next;
            cur.next=next;
            pre=pre.next;
            cur=next;
        }
        return dummy.next;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res = null;
        printRandLinkedList(head);
        res = copyListWithRand(head);
        printRandLinkedList(res);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res = copyListWithRand(head);
        printRandLinkedList(res);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
