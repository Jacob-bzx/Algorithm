package chapter2_list_problem;

import java.util.HashSet;

public class Problem_13_RemoveRepetition {
    // Time:O(N) Space:O(N)
    public static void removeRep1(Node head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (!set.contains(cur.value)) {
                set.add(cur.value);
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
    }

    // Time:O(N^2) Space:O(1)
    public static void removeRep2(Node head) {
        while (head != null) {
            Node cur = head.next;
            Node pre = head;
            while (cur != null) {
                if (cur.value == head.value) {
                    pre.next=cur.next;
                } else {
                    pre=cur;
                }
                cur=cur.next;
            }
            head=head.next;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep1(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep2(head);
        printLinkedList(head);

    }
}
